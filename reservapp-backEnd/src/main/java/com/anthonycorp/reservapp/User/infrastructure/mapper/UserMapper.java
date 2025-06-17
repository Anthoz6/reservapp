package com.anthonycorp.reservapp.User.infrastructure.mapper;

import com.anthonycorp.reservapp.User.domain.request.CreateUserDto;
import com.anthonycorp.reservapp.User.domain.response.UserResponseDto;

import com.anthonycorp.reservapp.User.infrastructure.model.UserEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto toDto(UserEntity userEntity);
    UserEntity toEntity(CreateUserDto createUserDto);
}
