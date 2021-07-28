package nl.novi.springboot.eindopdracht.model;

import java.io.Serializable;
import java.util.Objects;

public class AuthorityKey implements Serializable {
    private String username;
    private String authority;

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        AuthorityKey key = (AuthorityKey) object;
        return username.equals(key.username) &&
                authority.equals(key.authority);
    }

    @Override
    public int hashCode(){
        return Objects.hash(username, authority);
    }
}
