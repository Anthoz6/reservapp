package com.anthonycorp.reservapp.Service.infrastructure.controller;

import com.anthonycorp.reservapp.Service.application.createservice.CreateServiceUseCase;
import com.anthonycorp.reservapp.Service.domain.request.CreateServiceDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceController {

    private final CreateServiceUseCase createServiceUseCase;

    @PostMapping
    public ResponseEntity<?> createService(@RequestBody @Valid CreateServiceDto createServiceDto) {
        return new ResponseEntity<>(createServiceUseCase.execute(createServiceDto), HttpStatus.CREATED);
    }

}
