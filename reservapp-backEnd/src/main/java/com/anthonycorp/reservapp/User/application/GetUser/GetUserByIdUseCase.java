package com.anthonycorp.reservapp.User.application.GetUser;


import com.anthonycorp.reservapp.User.domain.response.UserNameDto;

public interface GetUserByIdUseCase {
    UserNameDto execute(Long id);

}
