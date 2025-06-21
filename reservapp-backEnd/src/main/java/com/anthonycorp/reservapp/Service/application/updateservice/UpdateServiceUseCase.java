package com.anthonycorp.reservapp.Service.application.UpdateService;

import com.anthonycorp.reservapp.Service.domain.request.UpdateServiceDto;
import com.anthonycorp.reservapp.Service.domain.response.ServiceResponseDto;

public interface UpdateServiceUseCase {
    ServiceResponseDto execute(Long serviceId, String providerEmail, UpdateServiceDto updateServiceDto);
}
