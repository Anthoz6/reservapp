package com.anthonycorp.reservapp.Auth.application.Login;

import com.anthonycorp.reservapp.Auth.domain.Dto.request.LoginDto;
import com.anthonycorp.reservapp.Auth.domain.Dto.response.LoginResponseDto;
import com.anthonycorp.reservapp.Utils.web.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponseDto execute(LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtUtils.createToken(authentication);
            return new LoginResponseDto(token, new Date());
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Credenciales inválidas", e);
        } catch (Exception e) {
            throw new RuntimeException("Error en el login", e);
        }
    }
}