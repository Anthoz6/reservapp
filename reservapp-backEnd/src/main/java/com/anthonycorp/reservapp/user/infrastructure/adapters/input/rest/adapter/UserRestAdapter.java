package com.anthonycorp.reservapp.user.infrastructure.adapters.input.rest.adapter;

import com.anthonycorp.reservapp.user.application.ports.input.UserServicePort;
import com.anthonycorp.reservapp.user.infrastructure.adapters.input.rest.mapper.UserRestMapper;
import com.anthonycorp.reservapp.user.infrastructure.adapters.input.rest.model.request.UserRequest;
import com.anthonycorp.reservapp.user.infrastructure.adapters.input.rest.model.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "Controllers/Endpoints to user")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestAdapter {

    private final UserServicePort servicePort;
    private final UserRestMapper restMapper;

    @Operation(summary = "List users")
    @GetMapping("/v1/api")
    public List<UserResponse> findAll() {
        return restMapper.toUserResponseList(servicePort.findAll());
    }

    @Operation(summary = "Find user")
    @GetMapping("/v1/api/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return restMapper.toUserResponse(servicePort.findById(id));
    }

    @Operation(summary = "Update user")
    @PutMapping("/v1/api/{id}")
    public UserResponse uptade(@PathVariable Long id, @Valid @RequestBody UserRequest request) {
        return restMapper.toUserResponse(servicePort.update(id, restMapper.toUser(request)));
    }

    @Operation(summary = "Delete user")
    @DeleteMapping("/v1/api/{id}")
    public void deleteById(@PathVariable Long id) {
        servicePort.deleteById(id);
    }
}
