package nl.novi.springboot.eindopdracht.service;

import nl.novi.springboot.eindopdracht.model.Authority;
import nl.novi.springboot.eindopdracht.model.User;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
public interface UserService {
    Collection<User> getAllUsers();

    Optional<User> getUserByName(String userName);

    public abstract String addUser(User user);
    public abstract void updateUser(String userName, User user);
    public abstract void deleteUser(String userName);

    public abstract Set<Authority> getAuthorities(String userName);
    public abstract void addAuthority(String userName, String authority);
    public abstract void deleteAuthority(String userName, String authority);
}
