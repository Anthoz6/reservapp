package com.anthonycorp.reservapp.Service.domain.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateServiceDto {
    @NotBlank(message = "The title cannot be empty.")
    private String title;

    @NotBlank(message = "The description cannot be empty.")
    private String description;

    @NotNull(message = "The price is mandatory")
    @Min(value = 0, message = "The price must be greater than or equal to 0")
    private Double price;
}
