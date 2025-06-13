package com.anthonycorp.reservapp.Service.application.deleteservice;

import com.anthonycorp.reservapp.Service.domain.response.ServiceResponseDto;

public interface DeleteServiceUseCase {
    void execute(Long serviceId, Long providerId);
}
