package com.anthonycorp.reservapp.User.domain.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserNameDto {
    private Long id;
    private String name;
}
