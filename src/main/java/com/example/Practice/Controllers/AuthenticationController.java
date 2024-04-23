package com.example.Practice.Controllers;

import com.example.Practice.Dto.AuthorizationRequestDto;
import com.example.Practice.Dto.JwtResponseDto;
import com.example.Practice.Dto.RefreshRequestDto;
import com.example.Practice.Service.Authentication;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final Authentication authentication;

    @PostMapping("/login")
    public JwtResponseDto authentication(@RequestBody AuthorizationRequestDto authorizationRequestDto) {
        return authentication.login(authorizationRequestDto.getLogin(), authorizationRequestDto.getPassword());
    }

    @PostMapping("/refresh")
    public JwtResponseDto login(@RequestBody RefreshRequestDto refreshRequestDto) {
        return authentication.refreshTokens(refreshRequestDto.getRefreshToken());
    }
}
