package nl.novi.springboot.eindopdracht.service;


import nl.novi.springboot.eindopdracht.config.CustomUserDetailService;
import nl.novi.springboot.eindopdracht.payload.request.AuthenticationRequest;
import nl.novi.springboot.eindopdracht.payload.response.AuthenticationResponse;
import nl.novi.springboot.eindopdracht.util.JasonWebTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService userDetailService;

    @Autowired
    JasonWebTokenUtil jwtUtil;

    @Override
    public AuthenticationResponse authenticatedUser(AuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getUserName();
        String password = authenticationRequest.getPassword();

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        }catch(BadCredentialsException ex){
            throw new UsernameNotFoundException("Incorrect username/password combination");
            }
        UserDetails userDetails = userDetailService.loadUserByUsername(username);

        String jasonWebToken = jwtUtil.generateToken(userDetails);
        return new AuthenticationResponse(jasonWebToken);
    }


}
