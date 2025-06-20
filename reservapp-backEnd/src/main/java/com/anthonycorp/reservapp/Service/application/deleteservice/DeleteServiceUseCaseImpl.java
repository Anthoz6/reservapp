package com.anthonycorp.reservapp.Service.application.DeleteService;

import com.anthonycorp.reservapp.Service.infrastructure.exception.ServiceNotFoundException;
import com.anthonycorp.reservapp.Service.infrastructure.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteServiceUseCaseImpl implements DeleteServiceUseCase {

    private final ServiceRepository serviceRepository;

    @Override
    public void execute(Long serviceId, Long providerId) {
        var service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ServiceNotFoundException("Service with ID " + serviceId + " not found"));

        if(!service.getProvider().getId().equals(providerId)) {
            throw new IllegalArgumentException("You are not authorized to delete this service");
        }

        serviceRepository.delete(service);
    }
}
