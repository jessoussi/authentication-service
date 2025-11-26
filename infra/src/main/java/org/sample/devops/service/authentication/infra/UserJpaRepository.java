package org.sample.devops.service.authentication.infra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByMail(String email);
}
