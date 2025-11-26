package org.sample.devops.service.authentication.infra;

import org.sample.devops.service.authentication.domain.User;
import org.sample.devops.service.authentication.domain.UserRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }


    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<UserEntity> userEntityOptional = this.userJpaRepository.findByMail(email);
        if (userEntityOptional.isPresent()){
            UserEntity userEntity = userEntityOptional.get();
            User user =  new User(userEntity.getUid(), userEntity.getMail(), userEntity.getFirstname(), userEntity.getLastname(), userEntity.getPassword());
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
