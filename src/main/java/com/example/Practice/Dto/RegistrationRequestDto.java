package com.example.Practice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationRequestDto {

    private String login = null;
    private String name = null;
    private String surname = null;
    private String password = null;
    private String profileImageUrl = null;
    private String phone = null;
}
