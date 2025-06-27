package com.anthonycorp.reservapp.Service.infrastructure.controller;

import com.anthonycorp.reservapp.Service.application.CreateService.CreateServiceUseCase;
import com.anthonycorp.reservapp.Service.application.GetAllServices.GetAllServicesUseCase;
import com.anthonycorp.reservapp.Service.application.GetServicesByProvider.GetServicesByProviderUseCase;
import com.anthonycorp.reservapp.Service.application.UpdateService.UpdateServiceUseCase;
import com.anthonycorp.reservapp.Service.application.DeleteService.DeleteServiceUseCase;
import com.anthonycorp.reservapp.Service.domain.request.CreateServiceDto;
import com.anthonycorp.reservapp.Service.domain.request.UpdateServiceDto;
import com.anthonycorp.reservapp.Service.domain.response.ServiceResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {

    private final CreateServiceUseCase createServiceUseCase;
    private final DeleteServiceUseCase deleteServiceUseCase;
    private final UpdateServiceUseCase updateServiceUseCase;
    private final GetServicesByProviderUseCase getServicesByProviderUseCase;
    private final GetAllServicesUseCase getAllServicesUseCase;

    @PostMapping
    public CompletableFuture<ResponseEntity<?>> createService(@RequestBody @Valid CreateServiceDto createServiceDto,
                                                              Authentication authentication) {
        String email = authentication.getName();
        return createServiceUseCase.execute(createServiceDto, email)
                .thenApply(response -> ResponseEntity.status(HttpStatus.CREATED).body(response));
    }

    @PatchMapping("/{serviceId}")
    public CompletableFuture<ResponseEntity<ServiceResponseDto>> updateService(@PathVariable Long serviceId,
                                                            @RequestBody @Valid UpdateServiceDto updateServiceDto,
                                                            Authentication authentication) {
        String providerEmail = authentication.getName();
        return updateServiceUseCase.execute(serviceId, providerEmail, updateServiceDto)
                .thenApply(services -> ResponseEntity.status(HttpStatus.OK).body(services));
    }

    @DeleteMapping("/{serviceId}")
    public CompletableFuture<ResponseEntity<Void>> deleteService(@PathVariable Long serviceId,
                                              Authentication authentication) {
        String providerEmail = authentication.getName(); // Basic Auth
        return deleteServiceUseCase.execute(serviceId, providerEmail)
                .thenApply(voidResult -> ResponseEntity.noContent().build());
    }

    @GetMapping("/me")
    public CompletableFuture<ResponseEntity<List<ServiceResponseDto>>> getByProvider(Authentication authentication) {
        String providerEmail = authentication.getName();
        return getServicesByProviderUseCase.execute(providerEmail)
                .thenApply(services -> ResponseEntity.status(HttpStatus.OK).body(services));
    }

    @GetMapping()
    public CompletableFuture<ResponseEntity<List<ServiceResponseDto>>> getAllServices() {
        return getAllServicesUseCase.execute()
                .thenApply(ResponseEntity::ok);
    }

}
