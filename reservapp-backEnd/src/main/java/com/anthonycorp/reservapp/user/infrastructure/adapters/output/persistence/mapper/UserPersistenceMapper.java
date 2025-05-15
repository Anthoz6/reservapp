package com.anthonycorp.reservapp.user.infrastructure.adapters.output.persistence.mapper;

import com.anthonycorp.reservapp.user.domain.model.User;
import com.anthonycorp.reservapp.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {
    UserEntity toUserEntity(User user);
    User toUser(UserEntity entity);
    List<User> toUserList(List<UserEntity> entityList);
}
