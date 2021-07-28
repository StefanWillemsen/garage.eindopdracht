package nl.novi.springboot.eindopdracht.config;


import nl.novi.springboot.eindopdracht.model.Authority;
import nl.novi.springboot.eindopdracht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;



    @Override
    public UserDetails loadUserByUsername(String username) {
            Optional<nl.novi.springboot.eindopdracht.model.User> user = userService.getUserByName(username);
            if (user.isEmpty()){
                throw new UsernameNotFoundException("username not found");
            }
                String password = user.get().getPassword();
                Set<Authority> authorities = user.get().getAuthorities();
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                for (Authority authority : authorities){
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
                }

                return new User(username, password, grantedAuthorities);
    }
}
