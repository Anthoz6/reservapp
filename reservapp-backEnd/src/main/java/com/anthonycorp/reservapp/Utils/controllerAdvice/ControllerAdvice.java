package com.anthonycorp.reservapp.Utils.controllerAdvice;

import com.anthonycorp.reservapp.Service.infrastructure.exception.ServiceNotFoundException;
import com.anthonycorp.reservapp.User.infrastructure.exception.EmailAlreadyInUse;
import com.anthonycorp.reservapp.User.infrastructure.exception.InvalidRole;
import com.anthonycorp.reservapp.User.infrastructure.exception.RoleNotFound;
import com.anthonycorp.reservapp.Utils.dto.ErrorDto;
import com.anthonycorp.reservapp.Utils.exception.TokenExpiredException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {


    public ResponseEntity<ErrorDto> handleRuntimeException(RuntimeException e) {
        return buildErrorResponse(
                e.getMessage(),
                ErrorCodes.GENERIC_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleEntityNotFoundException(EntityNotFoundException e) {
        return buildErrorResponse(
                e.getMessage(),
                ErrorCodes.ENTITY_NOT_FOUND_ERROR,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDto> handleBadRequestException(BadRequestException e) {
        return buildErrorResponse(
                e.getMessage(),
                ErrorCodes.BAD_REQUEST_ERROR,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleValidationExceptions(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        return new ResponseEntity<>(ErrorDto.builder()
                .message("Validation failed")
                .errorCode(ErrorCodes.BAD_REQUEST_ERROR)
                .details(errors)
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(EmailAlreadyInUse.class)
    public ResponseEntity<ErrorDto> handleEmailAlreadyInUseException(EmailAlreadyInUse e) {
        return buildErrorResponse(
                e.getMessage(),
                ErrorCodes.EMAIL_ALREADY_IN_USE,
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleGenericException(Exception e) {
        return buildErrorResponse(
                "An unexpected error occurred. Please contact support.",
                ErrorCodes.GENERIC_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(RoleNotFound.class)
    public ResponseEntity<ErrorDto> handleGenericException(RoleNotFound e) {
        return buildErrorResponse(
                e.getMessage(),
                ErrorCodes.ENTITY_NOT_FOUND_ERROR,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidRole.class)
    public ResponseEntity<ErrorDto> handleInvalidRoleException(InvalidRole e) {
        return buildErrorResponse(
                e.getMessage(),
                ErrorCodes.BAD_REQUEST_ERROR,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleServiceNotFound(ServiceNotFoundException e) {
        return buildErrorResponse(
                e.getMessage(),
                ErrorCodes.ENTITY_NOT_FOUND_ERROR,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorDto> handleUsernameNotFoundException( UsernameNotFoundException e) {
        return buildErrorResponse(
                e.getMessage(),
                ErrorCodes.BAD_REQUEST_ERROR,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<ErrorDto> handleJwtVerificationException(JWTVerificationException e) {
        return buildErrorResponse(
                e.getMessage(),
                ErrorCodes.INVALID_TOKEN,
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDto> handleAccessDeniedException(AccessDeniedException e) {
        return buildErrorResponse(
                "You do not have permission to perform this action.",
                ErrorCodes.ACCESS_DENIED,
                HttpStatus.FORBIDDEN
        );
    }


    @ExceptionHandler(TokenExpiredException .class)
    public ResponseEntity<ErrorDto> handleExpiredJwtException( TokenExpiredException e) {
        return buildErrorResponse(
                e.getMessage(),
                ErrorCodes.TOKEN_EXPIRED,
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<ErrorDto> handleMessagingException(MessagingException e) {
        return buildErrorResponse(
                e.getMessage(),
                ErrorCodes.MESSAGING_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    // Method to create A Error dto
    private ResponseEntity<ErrorDto> buildErrorResponse(String errorMessage, ErrorCodes errorCode, HttpStatus httpStatus) {
        return new ResponseEntity<>(ErrorDto.builder()
                .message(errorMessage)
                .errorCode(errorCode)
                .timestamp(LocalDateTime.now())
                .build(), httpStatus); //return error dto with the http status
    }
}
