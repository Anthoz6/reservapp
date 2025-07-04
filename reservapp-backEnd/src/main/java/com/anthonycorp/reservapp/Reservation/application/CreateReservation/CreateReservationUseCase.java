package com.anthonycorp.reservapp.Reservation.application.CreateReservation;

import com.anthonycorp.reservapp.Reservation.domain.request.CreateReservationDto;
import com.anthonycorp.reservapp.Reservation.domain.response.ReservationResponseDto;


public interface CreateReservationUseCase {
    ReservationResponseDto execute(String email, CreateReservationDto dto);
}
