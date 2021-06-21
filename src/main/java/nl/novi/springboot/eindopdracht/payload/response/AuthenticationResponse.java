package nl.novi.springboot.eindopdracht.payload.response;

public class AuthenticationResponse {

    private String jasonWebToken;

    public AuthenticationResponse(String jasonWebToken){
        this.jasonWebToken = jasonWebToken;
    }

    public String getJasonWebToken() {
        return jasonWebToken;
    }

}
