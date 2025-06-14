package com.anthonycorp.reservapp.Reservation.infrastructure.repository;

import com.anthonycorp.reservapp.Reservation.infrastructure.model.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findByCustomerId(Long customerId);
    List<ReservationEntity> findByProviderId(Long providerId);
}
