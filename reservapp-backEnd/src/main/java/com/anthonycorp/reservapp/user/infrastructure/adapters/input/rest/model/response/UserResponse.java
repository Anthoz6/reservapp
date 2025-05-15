package com.anthonycorp.reservapp.user.infrastructure.adapters.input.rest.model.response;

import com.anthonycorp.reservapp.user.domain.model.enums.Role;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private Role role;
}
