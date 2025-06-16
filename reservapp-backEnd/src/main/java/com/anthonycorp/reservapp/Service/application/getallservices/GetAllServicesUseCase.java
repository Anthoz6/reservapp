package com.anthonycorp.reservapp.Service.application.getallservices;

import com.anthonycorp.reservapp.Service.domain.response.ServiceResponseDto;

import java.util.List;

public interface GetAllServicesUseCase {
    List<ServiceResponseDto> execute();
}
