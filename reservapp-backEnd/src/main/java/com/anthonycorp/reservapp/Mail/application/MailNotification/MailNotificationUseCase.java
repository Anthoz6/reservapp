package com.anthonycorp.reservapp.Mail.application.MailNotification;

import com.anthonycorp.reservapp.Mail.domain.Request.ReservationConfirmationDto;

public interface MailNotificationUseCase {
    void sendReservationConfirmation(ReservationConfirmationDto confirmationDto);
}
