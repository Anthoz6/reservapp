package com.anthonycorp.reservapp.User.domain.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {

    @Size(min = 3, max = 50, message = "The username must be between 3 and 50 characters")
    private String name;

}
