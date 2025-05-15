package com.anthonycorp.reservapp.user.infrastructure.adapters.input.rest.advice;

import com.anthonycorp.reservapp.common.error.ErrorResponse;
import com.anthonycorp.reservapp.user.domain.exception.UserNotFoundException;
import com.anthonycorp.reservapp.user.infrastructure.adapters.input.rest.adapter.UserRestAdapter;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.anthonycorp.reservapp.user.utils.ErrorCatalog.*;

@RestControllerAdvice(assignableTypes = {UserRestAdapter.class})
public class UserControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFoundException() {
        return ErrorResponse.builder()
                .code(USER_NOT_FOUND.getCode())
                .message(USER_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException (MethodArgumentNotValidException exception) {

        BindingResult result = exception.getBindingResult();

        return ErrorResponse.builder()
                .code(INVALID_USER.getCode())
                .message(INVALID_USER.getMessage())
                .details(result.getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericError (Exception exception) {
        return ErrorResponse.builder()
                .code(GENERIC_ERROR.getCode())
                .message(GENERIC_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }
}
