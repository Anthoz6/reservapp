package com.anthonycorp.reservapp.Reservation.domain.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDto {
    private Long id;
    private String customerName;
    private String providerName;
    private String serviceTitle;
    private String date;
    private String time;
    private String status;
}
