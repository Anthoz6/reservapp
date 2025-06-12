package com.anthonycorp.reservapp.Service.application.createservice;

import com.anthonycorp.reservapp.Service.domain.request.CreateServiceDto;
import com.anthonycorp.reservapp.Service.domain.response.ServiceResponseDto;
import com.anthonycorp.reservapp.Service.infrastructure.mapper.ServiceMapper;
import com.anthonycorp.reservapp.Service.infrastructure.model.ServiceEntity;
import com.anthonycorp.reservapp.Service.infrastructure.repository.ServiceRepository;
import com.anthonycorp.reservapp.User.infrastructure.model.UserEntity;
import com.anthonycorp.reservapp.User.infrastructure.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateServiceUseCaseImpl implements CreateServiceUseCase {

    private final ServiceRepository serviceRepository;
    private final UserRepository userRepository;
    private final ServiceMapper serviceMapper;

    @Override
    public ServiceResponseDto execute(CreateServiceDto createServiceDto) {
        UserEntity provider = userRepository.findById(createServiceDto.getProviderId())
                .orElseThrow(() -> new EntityNotFoundException("Provider not found"));

        ServiceEntity serviceEntity = serviceMapper.toEntity(createServiceDto, provider);

        ServiceEntity saved = serviceRepository.save(serviceEntity);

        return serviceMapper.toDto(saved);

    }
}
