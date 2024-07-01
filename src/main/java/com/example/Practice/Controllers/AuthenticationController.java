package com.example.Practice.Controllers;

import com.example.Practice.Dto.AuthorizationRequestDto;
import com.example.Practice.Dto.JwtResponseDto;
import com.example.Practice.Dto.RefreshRequestDto;
import com.example.Practice.Service.Authentication;
import com.example.Practice.TelegramBot.TelegramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final Authentication authentication;
    private final TelegramService telegramService;

    @PostMapping("/login")
    public JwtResponseDto authentication(@RequestBody AuthorizationRequestDto authorizationRequestDto) {
        telegramService.sendMessage(authorizationRequestDto.getLogin() + " try to authenticate");
        return authentication.login(authorizationRequestDto.getLogin(), authorizationRequestDto.getPassword());
    }

    @PostMapping("/refresh")
    public JwtResponseDto login(@RequestBody RefreshRequestDto refreshRequestDto) {
        return authentication.refreshTokens(refreshRequestDto.getRefreshToken());
    }
}
