package com.anthonycorp.reservapp.Reservation.application.GetMyReservations;

import com.anthonycorp.reservapp.Reservation.domain.response.ReservationResponseDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface GetMyReservationsUseCase {
    CompletableFuture<List<ReservationResponseDto>> getReservationAsCustomer(String email);
}
