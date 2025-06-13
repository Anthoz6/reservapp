package com.anthonycorp.reservapp.Service.application.updateservice;

import com.anthonycorp.reservapp.Service.domain.request.UpdateServiceDto;
import com.anthonycorp.reservapp.Service.domain.response.ServiceResponseDto;

public interface UpdateServiceUseCase {
    ServiceResponseDto execute(Long serviceId, Long providerId, UpdateServiceDto updateServiceDto);
}
