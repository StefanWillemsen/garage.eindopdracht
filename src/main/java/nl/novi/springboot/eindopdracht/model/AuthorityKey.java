package nl.novi.springboot.eindopdracht.model;

import java.io.Serializable;
import java.util.Objects;

public class AuthorityKey implements Serializable {
    private String userName;
    private String authorityLevel;


    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        AuthorityKey key = (AuthorityKey) object;
        return userName.equals(key.userName) &&
                authorityLevel.equals(key.authorityLevel);
    }

    @Override
    public int hashCode(){
        return Objects.hash(userName, authorityLevel);
    }
}
