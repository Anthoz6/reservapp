package com.anthonycorp.reservapp.Service.infrastructure.repository;

import com.anthonycorp.reservapp.Service.infrastructure.model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
    List<ServiceEntity> findAllByProviderId(Long providerId);
}
