package org.sample.devops.service.authentication.domain;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryPort {

    public Optional<User> getUserByEmail(String email);
}
