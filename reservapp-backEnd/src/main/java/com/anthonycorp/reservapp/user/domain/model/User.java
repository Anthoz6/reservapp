package com.anthonycorp.reservapp.user.domain.model;

import com.anthonycorp.reservapp.user.domain.model.enums.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
}
