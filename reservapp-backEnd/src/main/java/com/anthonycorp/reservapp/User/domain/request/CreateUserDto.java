package com.anthonycorp.reservapp.User.domain.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    @Email(message = "The email should be valid")
    @NotEmpty(message = "The email cannot be empty")
    private String email;

    @NotEmpty(message = "The name cannot be empty")
    @Size(min = 3, max = 50, message = "The name must be between 3 and 50 characters")
    private String name;

    @NotEmpty(message = "The password cannot be empty")
    @Size(min = 6, message = "The password must be at least 6 characters long")
    private String password;

    @NotNull(message = "the rol cannot be null")
    private Long rolId;

}
