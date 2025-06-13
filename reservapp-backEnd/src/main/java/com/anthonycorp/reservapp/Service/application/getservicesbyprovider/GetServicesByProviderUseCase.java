package com.anthonycorp.reservapp.Service.application.getservicesbyprovider;

import com.anthonycorp.reservapp.Service.domain.response.ServiceResponseDto;

import java.util.List;

public interface GetServicesByProviderUseCase {
    List<ServiceResponseDto> execute(Long providerId);
}
