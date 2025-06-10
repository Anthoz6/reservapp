package com.anthonycorp.reservapp.User.infrastructure.repository;

import com.anthonycorp.reservapp.User.infrastructure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
