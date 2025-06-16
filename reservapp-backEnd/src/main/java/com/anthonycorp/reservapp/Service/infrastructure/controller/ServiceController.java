package com.anthonycorp.reservapp.Service.infrastructure.controller;

import com.anthonycorp.reservapp.Service.application.createservice.CreateServiceUseCase;
import com.anthonycorp.reservapp.Service.application.getallservices.GetAllServicesUseCase;
import com.anthonycorp.reservapp.Service.application.getservicesbyprovider.GetServicesByProviderUseCase;
import com.anthonycorp.reservapp.Service.application.updateservice.UpdateServiceUseCase;
import com.anthonycorp.reservapp.Service.application.deleteservice.DeleteServiceUseCase;
import com.anthonycorp.reservapp.Service.domain.request.CreateServiceDto;
import com.anthonycorp.reservapp.Service.domain.request.UpdateServiceDto;
import com.anthonycorp.reservapp.Service.domain.response.ServiceResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceController {

    private final CreateServiceUseCase createServiceUseCase;
    private final DeleteServiceUseCase deleteServiceUseCase;
    private final UpdateServiceUseCase updateServiceUseCase;
    private final GetServicesByProviderUseCase getServicesByProviderUseCase;
    private final GetAllServicesUseCase getAllServicesUseCase;

    @PostMapping
    public ResponseEntity<?> createService(@RequestBody @Valid CreateServiceDto createServiceDto) {
        return new ResponseEntity<>(createServiceUseCase.execute(createServiceDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{serviceId}")
    public ResponseEntity<ServiceResponseDto> updateService(@PathVariable Long serviceId,
                                                            @RequestParam Long providerId,
                                                            @RequestBody @Valid UpdateServiceDto updateServiceDto) {
        return ResponseEntity.ok(updateServiceUseCase.execute(serviceId, providerId, updateServiceDto));
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable Long serviceId,
                                              @RequestParam Long providerId) {
        deleteServiceUseCase.execute(serviceId, providerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<ServiceResponseDto>> getByProvider(@PathVariable Long providerId) {
        return ResponseEntity.ok(getServicesByProviderUseCase.execute(providerId));
    }

    @GetMapping()
    public ResponseEntity<List<ServiceResponseDto>> getAllServices() {
        List<ServiceResponseDto> services = getAllServicesUseCase.execute();
        return ResponseEntity.ok(services);
    }

}
