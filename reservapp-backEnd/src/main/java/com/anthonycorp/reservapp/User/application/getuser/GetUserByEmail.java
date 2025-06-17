package com.anthonycorp.reservapp.User.application.getuser;


import com.anthonycorp.reservapp.User.infrastructure.model.UserEntity;

public interface GetUserByEmail {
    UserEntity execute(String email);

}
