package nl.novi.springboot.eindopdracht.controller;

import nl.novi.springboot.eindopdracht.payload.request.AuthenticationRequest;
import nl.novi.springboot.eindopdracht.payload.response.AuthenticationResponse;
import nl.novi.springboot.eindopdracht.service.UserAuthenticationService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/")
public class AuthenticatedController {
    UserAuthenticationService userAuthenticationService;

    @GetMapping(value = "authenticated")
    public ResponseEntity<Object> authenticated(Authentication authentication, Principal principal){
        return ResponseEntity.ok().body(principal);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        AuthenticationResponse authenticationResponse = userAuthenticationService.authenticatedUser(authenticationRequest);
        return ResponseEntity.ok(authenticationResponse);
    }
}
