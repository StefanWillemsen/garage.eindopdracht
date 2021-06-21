package nl.novi.springboot.eindopdracht.service;


import nl.novi.springboot.eindopdracht.payload.request.AuthenticationRequest;
import nl.novi.springboot.eindopdracht.payload.response.AuthenticationResponse;

public interface UserAuthenticationService {

    public AuthenticationResponse authenticatedUser(AuthenticationRequest authenticationRequest);
}
