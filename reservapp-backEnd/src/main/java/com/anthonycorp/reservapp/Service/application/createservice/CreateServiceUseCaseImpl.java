package com.anthonycorp.reservapp.Service.application.createservice;

import com.anthonycorp.reservapp.Service.domain.request.CreateServiceDto;
import com.anthonycorp.reservapp.Service.domain.response.ServiceResponseDto;
import com.anthonycorp.reservapp.Service.infrastructure.mapper.ServiceMapper;
import com.anthonycorp.reservapp.Service.infrastructure.model.ServiceEntity;
import com.anthonycorp.reservapp.Service.infrastructure.repository.ServiceRepository;
import com.anthonycorp.reservapp.User.domain.Role.RoleEnum;
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
                .orElseThrow(() -> new EntityNotFoundException("Provider with ID " + createServiceDto.getProviderId() + " not found"));

        // Verificar que su rol sea PROVIDER
        if (provider.getRoleEntity() == null || !RoleEnum.PROVIDER.equals(provider.getRoleEntity().getRole())) {
            throw new IllegalArgumentException("The user is not authorized to create services");
        }

        ServiceEntity serviceEntity = serviceMapper.toEntity(createServiceDto, provider);
        return serviceMapper.toDto(serviceRepository.save(serviceEntity));

    }
}
