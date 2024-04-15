package com.example.Practice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDto {

    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;

}
