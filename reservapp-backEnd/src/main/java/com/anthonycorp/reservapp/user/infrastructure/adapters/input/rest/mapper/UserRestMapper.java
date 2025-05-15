package com.anthonycorp.reservapp.user.infrastructure.adapters.input.rest.mapper;

import com.anthonycorp.reservapp.user.domain.model.User;
import com.anthonycorp.reservapp.user.infrastructure.adapters.input.rest.model.request.UserRequest;
import com.anthonycorp.reservapp.user.infrastructure.adapters.input.rest.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRestMapper {
    User toUser(UserRequest request);
    UserResponse toUserResponse(User user);
    List<UserResponse> toUserResponseList(List<User> userList);
}
