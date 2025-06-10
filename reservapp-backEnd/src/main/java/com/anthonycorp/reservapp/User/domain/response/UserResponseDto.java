package com.anthonycorp.reservapp.User.domain.response;

import com.anthonycorp.reservapp.User.infrastructure.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String password;
    private Role role;
}
