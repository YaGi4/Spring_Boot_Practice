package com.example.Practice.Dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDto {

    @Pattern(regexp = "([a-zA-Z])(?=.*[a-zA-Z0-9]).{6,20}")
    private String login;
    @Pattern(regexp = "(?=.*[a-zA-Z]).{2,20}")
    private String name;
    @Pattern(regexp = "(?=.*[a-zA-Z]).{2,20}")
    private String surname;
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%^&+=\\-_]).{8,20}")
    private String password;
    private String profileImageUrl;
    @Pattern(regexp = "(\\+7|8)([0-9]{10})")
    private String phone;
}
