package com.anthonycorp.reservapp.User.infrastructure.controller;

import com.anthonycorp.reservapp.User.application.createuser.CreateUserUseCase;
import com.anthonycorp.reservapp.User.application.updateuser.UpdateUserUseCase;
import com.anthonycorp.reservapp.User.domain.request.CreateUserDto;
import com.anthonycorp.reservapp.User.domain.request.UpdateUserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
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

    @GetMapping()
    public String hello() {
        return "Hello World";
    }

}
