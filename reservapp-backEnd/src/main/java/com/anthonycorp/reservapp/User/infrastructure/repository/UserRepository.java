package com.anthonycorp.reservapp.User.infrastructure.repository;
import com.anthonycorp.reservapp.User.infrastructure.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByEmail(String email);
}
