package com.anthonycorp.reservapp.Service.application.createservice;

import com.anthonycorp.reservapp.Service.domain.request.CreateServiceDto;
import com.anthonycorp.reservapp.Service.domain.response.ServiceResponseDto;

public interface CreateServiceUseCase {
    ServiceResponseDto execute(CreateServiceDto createServiceDto);
}
