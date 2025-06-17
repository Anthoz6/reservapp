package com.anthonycorp.reservapp.User.infrastructure.repository;
import com.anthonycorp.reservapp.User.infrastructure.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
