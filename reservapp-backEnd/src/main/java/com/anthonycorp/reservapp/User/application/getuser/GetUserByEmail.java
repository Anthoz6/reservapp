package com.anthonycorp.reservapp.User.application.GetUser;


import com.anthonycorp.reservapp.User.infrastructure.model.UserEntity;

public interface GetUserByEmail {
    UserEntity execute(String email);

}
