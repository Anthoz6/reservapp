package com.anthonycorp.reservapp.Service.infrastructure.mapper;

import com.anthonycorp.reservapp.Service.domain.request.CreateServiceDto;
import com.anthonycorp.reservapp.Service.domain.response.ServiceResponseDto;
import com.anthonycorp.reservapp.Service.infrastructure.model.ServiceEntity;
import com.anthonycorp.reservapp.User.infrastructure.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    @Mappings({
            @Mapping(source = "provider.name", target = "providerName"),
            @Mapping(source = "provider.id", target = "providerId")
    })

    ServiceResponseDto toDto(ServiceEntity serviceEntity);
    default ServiceEntity toEntity(CreateServiceDto createServiceDto, UserEntity provider) {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setTitle(createServiceDto.getTitle());
        serviceEntity.setDescription(createServiceDto.getDescription());
        serviceEntity.setPrice(createServiceDto.getPrice());
        serviceEntity.setProvider(provider);
        return serviceEntity;
    }
}
