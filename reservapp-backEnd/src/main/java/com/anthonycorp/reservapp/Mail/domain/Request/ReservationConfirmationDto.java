package com.anthonycorp.reservapp.Mail.domain.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationConfirmationDto {

    private String customerName;
    private String customerEmail;
    private Long reservationId;
    private LocalDate date;
    private LocalTime time;
    private String serviceName;
}
