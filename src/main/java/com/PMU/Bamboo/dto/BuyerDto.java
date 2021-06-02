package com.PMU.Bamboo.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuyerDto {

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "LastName is mandatory")
    private String lastName;

    @NotBlank(message = "Address is mandatory")
    private String address;
}