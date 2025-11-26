package org.sample.devops.service.authentication.domain;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepositoryPort userRepositoryPort;

    public AuthenticationService(UserRepositoryPort userRepositoryPort){
        this.userRepositoryPort = userRepositoryPort;
    }

    public Optional<User> authenticate(String mail, String password){
        Optional<User> user = this.userRepositoryPort.getUserByEmail(mail);
        if (user.isPresent()){
            if (user.get().getPassword().equals(password)){
                return user;
            }
        }
        return Optional.empty();
    }
}
