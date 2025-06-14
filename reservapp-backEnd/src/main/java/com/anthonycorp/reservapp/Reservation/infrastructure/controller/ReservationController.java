package com.anthonycorp.reservapp.Reservation.infrastructure.controller;

import com.anthonycorp.reservapp.Reservation.application.createsreservation.CreateReservationUseCase;
import com.anthonycorp.reservapp.Reservation.domain.request.CreateReservationDto;
import com.anthonycorp.reservapp.Reservation.domain.response.ReservationResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final CreateReservationUseCase createReservationUseCase;

    @PostMapping
    public ResponseEntity<ReservationResponseDto> createReservation(
            @Valid @RequestBody CreateReservationDto dto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        ReservationResponseDto response = createReservationUseCase.execute(email, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
