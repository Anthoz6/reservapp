package com.anthonycorp.reservapp.Reservation.infrastructure.mapper;

import com.anthonycorp.reservapp.Reservation.domain.response.ReservationResponseDto;
import com.anthonycorp.reservapp.Reservation.infrastructure.model.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel  = "spring")
public interface ReservationMapper {
    @Mapping(source = "service.title", target = "serviceTitle")
    @Mapping(source = "provider.name", target = "providerName")
    @Mapping(source = "customer.name", target = "customerName")
    ReservationResponseDto toDto(ReservationEntity reservation);
}
