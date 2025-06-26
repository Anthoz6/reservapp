package com.anthonycorp.reservapp.Reservation.application.CreateReservation;

import com.anthonycorp.reservapp.Reservation.domain.request.CreateReservationDto;
import com.anthonycorp.reservapp.Reservation.domain.response.ReservationResponseDto;

import java.util.concurrent.CompletableFuture;

public interface CreateReservationUseCase {
    CompletableFuture<ReservationResponseDto> execute(String email, CreateReservationDto dto);
}
