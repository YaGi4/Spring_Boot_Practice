package com.example.Practice.Dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationRequestDto {

    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,20}")
    private String login;
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%^&+=\\-_]).{8,20}")
    private String password;
}
