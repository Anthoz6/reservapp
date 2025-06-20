package com.anthonycorp.reservapp.Reservation.infrastructure.controller;

import com.anthonycorp.reservapp.Reservation.application.CreateReservation.CreateReservationUseCase;
import com.anthonycorp.reservapp.Reservation.application.GetMyReservations.GetMyReservationsUseCase;
import com.anthonycorp.reservapp.Reservation.domain.request.CreateReservationDto;
import com.anthonycorp.reservapp.Reservation.domain.response.ReservationResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {

    private final CreateReservationUseCase createReservationUseCase;
    private final GetMyReservationsUseCase getMyReservationsUseCase;

    @PostMapping
    public ResponseEntity<ReservationResponseDto> createReservation(
            @Valid @RequestBody CreateReservationDto dto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        ReservationResponseDto response = createReservationUseCase.execute(email, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/me")
    public ResponseEntity<List<ReservationResponseDto>> getMyReservationsAsCustomer(Authentication authentication) {
        String email = authentication.getName();
        List<ReservationResponseDto> reservations = getMyReservationsUseCase.getReservationAsCustomer(email);
        return new ResponseEntity<>((reservations), HttpStatus.OK);
    }
}
