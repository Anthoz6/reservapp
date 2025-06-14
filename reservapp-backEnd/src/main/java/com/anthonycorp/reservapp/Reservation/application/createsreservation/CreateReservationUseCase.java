package com.anthonycorp.reservapp.Reservation.application.createsreservation;

import com.anthonycorp.reservapp.Reservation.domain.request.CreateReservationDto;
import com.anthonycorp.reservapp.Reservation.domain.response.ReservationResponseDto;
import com.anthonycorp.reservapp.Reservation.infrastructure.model.ReservationEntity;

public interface CreateReservationUseCase {
    ReservationResponseDto execute(String email, CreateReservationDto dto);
}
