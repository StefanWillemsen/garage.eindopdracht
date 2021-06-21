package nl.novi.springboot.eindopdracht.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(AuthorityKey.class)
@Table(name = "authorities")
public class Authority implements Serializable {
    @Id
    @Column(nullable = false)
    private String userName;

    @Id
    @Column(nullable = false)
    private String authorityLevel;

    public Authority() {
    }

    public Authority(String userName, String authorityLevel) {
        this.userName = userName;
        this.authorityLevel = authorityLevel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthorityLevel() {
        return authorityLevel;
    }

    public void setAuthorityLevel(String authorityLevel) {
        this.authorityLevel = authorityLevel;
    }
}
