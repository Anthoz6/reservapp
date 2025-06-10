package com.anthonycorp.reservapp.User.application.getuser;

import com.anthonycorp.reservapp.User.infrastructure.model.User;

public interface GetUserByEmail {
    User execute(String email);
}
