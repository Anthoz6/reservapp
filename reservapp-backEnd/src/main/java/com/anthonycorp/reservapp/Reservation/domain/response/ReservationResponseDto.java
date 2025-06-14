package com.anthonycorp.reservapp.Reservation.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDto {
    private Long id;
    private String customerName;
    private String providerName;
    private String serviceTitle;
    private LocalDate date;
    private LocalTime time;
    private String status;
}
