package com.example.Practice.Service;

import com.example.Practice.Dto.JwtResponseDto;
import com.example.Practice.Entity.User;
import com.example.Practice.Exception.TokensException;
import com.example.Practice.Exception.UserNotFoundException;
import com.example.Practice.Exception.WrongPasswordException;
import com.example.Practice.Repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Authentication {

    private final Redis redis;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public JwtResponseDto login(String login, String password) {
        User user;
        user = userRepository.getUserByLogin(login);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        else {
            if(user.getLocked()) {
                throw new TokensException("User is locked");
            }
            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new WrongPasswordException("Wrong password");
            }
            String accessToken = jwtProvider.generateAccessToken(user);
            String refreshToken = jwtProvider.generateRefreshToken(user);
            redis.setRefreshTokenByLogin(user.getLogin(), refreshToken);
            return new JwtResponseDto(accessToken, refreshToken);
        }
    }

    public JwtResponseDto refreshTokens(String oldRefreshToken) {
        if (jwtProvider.validateRefreshToken(oldRefreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(oldRefreshToken);
            final String login = claims.getSubject();

                User user;
                user = userRepository.getUserByLogin(login);
                if(user == null) {
                    throw new TokensException("User not found");
                }
                else {
                    if (user.getLocked()) {
                        throw new TokensException("User is locked");
                    }
                    String refreshTokenByLogin = redis.getRefreshTokenByLogin(user.getLogin());
                    if(refreshTokenByLogin != null && refreshTokenByLogin.equals(oldRefreshToken)) {
                        String newAccessToken = jwtProvider.generateAccessToken(user);
                        String newRefreshToken = jwtProvider.generateRefreshToken(user);
                        redis.setRefreshTokenByLogin(user.getLogin(), newRefreshToken);
                        return new JwtResponseDto(newAccessToken, newRefreshToken);
                    }
                    else
                        throw new TokensException("Token not registered");
                }
        }
        throw new TokensException("Token not valid");
    }

    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
