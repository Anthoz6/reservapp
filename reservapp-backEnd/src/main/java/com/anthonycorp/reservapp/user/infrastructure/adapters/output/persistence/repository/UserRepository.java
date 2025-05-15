package com.anthonycorp.reservapp.user.infrastructure.adapters.output.persistence.repository;

import com.anthonycorp.reservapp.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
