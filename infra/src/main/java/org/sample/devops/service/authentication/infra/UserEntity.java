package org.sample.devops.service.authentication.infra;

import jakarta.persistence.*;

@Entity
@Table(name= "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;
    private String mail;
    private String firstname;
    private String lastname;
    private String password;
    private String ville;

    public UserEntity() {
    }

    public UserEntity(String mail, String firstname, String lastname, String password, String ville) {
        this.mail = mail;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.ville = ville;
    }

    public Long getUid() {
        return uid;
    }

    public String getMail() {
        return mail;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getVille() {
        return ville;
    }
}
