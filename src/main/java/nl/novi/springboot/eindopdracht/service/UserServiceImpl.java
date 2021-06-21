package nl.novi.springboot.eindopdracht.service;

import nl.novi.springboot.eindopdracht.exception.RecordNotFoundException;
import nl.novi.springboot.eindopdracht.model.Authority;
import nl.novi.springboot.eindopdracht.model.User;
import nl.novi.springboot.eindopdracht.repository.UserRepsitory;
import nl.novi.springboot.eindopdracht.util.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepsitory userRepsitory;

    @Override
    public Collection<User> getAllUsers(){
        return userRepsitory.findAll();
    }

    @Override
    public Optional<User> getUserByName(String username){
        return userRepsitory.findById(username);
    }

    public String addUser(User user){
        String randomString = RandomStringGenerator.generateRandomString(20);
        user.setApiKey(randomString);
        User newUser = userRepsitory.save(user);
        return newUser.getUserName();
    }

    @Override
    public void deleteUser(String userName){
        userRepsitory.deleteById(userName);
    }

    @Override
    public void updateUser(String userName, User user){
        if(userRepsitory.existsById(userName)){
            User newUser = userRepsitory.findById(userName).get();
            newUser.setPassword(user.getPassword());
            newUser.setApiKey(user.getApiKey());
            newUser.setEmail(user.getEmail());
            userRepsitory.save(newUser);
        } else{
            throw new RecordNotFoundException();
        }
    }
    @Override
    public Set<Authority> getAuthorities(String userName) {
        if (userRepsitory.existsById(userName)) {
            User user = userRepsitory.findById(userName).get();
            return user.getAuthorities();
        } else {
            throw new RecordNotFoundException();
        }
    }
        @Override
        public void addAuthority(String userName, String authority){
            if(userRepsitory.existsById(userName)){
                User user = userRepsitory.findById(userName).get();
                user.addAuthorities(new Authority(userName, authority));
            }else{
                throw new RecordNotFoundException();
            }

        }

        @Override
    public void deleteAuthority(String userName, String authority){
        if(userRepsitory.existsById(userName)){
            User user = userRepsitory.findById(userName).get();
            Authority authorityToDelete = user.getAuthorities()
                                                .stream()
                                                .filter((a) -> a.getAuthorityLevel()
                                                                .equalsIgnoreCase(authority))
                                                .findAny()
                                                .get();
            user.deleteAuthority(authorityToDelete);
            userRepsitory.save(user);
        }else{
            throw new RecordNotFoundException();
        }
        }
    }


