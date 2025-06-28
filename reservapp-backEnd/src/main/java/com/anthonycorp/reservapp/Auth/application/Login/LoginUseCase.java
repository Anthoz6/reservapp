package com.anthonycorp.reservapp.Auth.application.Login;

import com.anthonycorp.reservapp.Auth.domain.Dto.request.LoginDto;
import com.anthonycorp.reservapp.Auth.domain.Dto.response.LoginResponseDto;

public interface LoginUseCase {
    LoginResponseDto execute(LoginDto loginDto);
}
