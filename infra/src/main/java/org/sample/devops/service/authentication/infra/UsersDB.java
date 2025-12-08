package org.sample.devops.service.authentication.infra;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class UsersDB {

    private static final Map<String, UserEntity> db = new HashMap<>();

    @PostConstruct
    private void initialize(){
        db.put("user1@mail.com", new UserEntity("user1@mail.com", "User1FirstName", "User1LastName", "password1", "Paris"));
        db.put("user2@mail.com", new UserEntity("user2@mail.com", "User2FirstName", "User2LastName", "password2", "Paris"));
    }

    public Optional<UserEntity> getUserByMail(String mail){
        return Optional.ofNullable(db.get(mail));
    }
}
