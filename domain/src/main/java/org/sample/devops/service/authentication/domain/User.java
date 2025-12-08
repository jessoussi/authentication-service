package org.sample.devops.service.authentication.domain;

public class User {

    private Long uid;
    private String mail;
    private String firstname;
    private String lastname;
    private String password;
    private String ville;

    public User() {
    }

    public User(Long uid, String mail, String firstname, String lastname, String password, String ville) {
        this.uid = uid;
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

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
