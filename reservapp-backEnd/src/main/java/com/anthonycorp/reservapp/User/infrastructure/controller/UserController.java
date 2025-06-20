package com.anthonycorp.reservapp.User.infrastructure.controller;

import com.anthonycorp.reservapp.User.application.CreateUser.CreateUserUseCase;
import com.anthonycorp.reservapp.User.application.UpdateUser.UpdateUserUseCase;
import com.anthonycorp.reservapp.User.domain.request.CreateUserDto;
import com.anthonycorp.reservapp.User.domain.request.UpdateUserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        return new ResponseEntity<>(createUserUseCase.execute(createUserDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody @Valid UpdateUserDto updateUserDto) {
        return  new ResponseEntity<>(updateUserUseCase.execute(userId, updateUserDto), HttpStatus.OK);
    }

}
