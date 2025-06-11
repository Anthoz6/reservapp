package com.anthonycorp.reservapp.Utils.controllerAdvice;

import com.anthonycorp.reservapp.User.infrastructure.exception.EmailAlreadyInUse;
import com.anthonycorp.reservapp.User.infrastructure.exception.InvalidRole;
import com.anthonycorp.reservapp.User.infrastructure.exception.RoleNotFound;
import com.anthonycorp.reservapp.Utils.dto.ErrorDto;
<<<<<<< HEAD
=======
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.JwtException;
>>>>>>> 8335205 (Module User Updated)
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
=======
import org.springframework.security.core.userdetails.UsernameNotFoundException;
>>>>>>> 8335205 (Module User Updated)
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
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
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

<<<<<<< HEAD
//    @ExceptionHandler(UsernameNotFoundException.class)
//    public ResponseEntity<ErrorDto> handleUsernameNotFoundException( UsernameNotFoundException e) {
//        return buildErrorResponse(
//                e.getMessage(),
//                ErrorCodes.BAD_REQUEST_ERROR,
//                HttpStatus.BAD_REQUEST
//        );
//    }
=======
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorDto> handleUsernameNotFoundException( UsernameNotFoundException e) {
        return buildErrorResponse(
                e.getMessage(),
                ErrorCodes.BAD_REQUEST_ERROR,
                HttpStatus.BAD_REQUEST
        );
    }
>>>>>>> 8335205 (Module User Updated)

//    @ExceptionHandler(JwtException.class)
//    public ResponseEntity<ErrorDto> handleJwtException( JwtException e) {
//        return buildErrorResponse(
//                e.getMessage(),
//                ErrorCodes.INVALID_TOKEN,
//                HttpStatus.UNAUTHORIZED
//        );
//    }
//
//    @ExceptionHandler(ExpiredJwtException.class)
//    public ResponseEntity<ErrorDto> handleExpiredJwtException( ExpiredJwtException e) {
//        return buildErrorResponse(
//                e.getMessage(),
//                ErrorCodes.TOKEN_EXPIRED,
//                HttpStatus.UNAUTHORIZED
//        );
//    }

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
