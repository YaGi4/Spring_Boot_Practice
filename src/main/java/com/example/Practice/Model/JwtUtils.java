package com.example.Practice.Model;

import com.example.Practice.Service.JwtAuthentication;
import io.jsonwebtoken.Claims;

public class JwtUtils {

    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication();
        String role = claims.get("role", String.class);
        jwtInfoToken.setAuthorities(Role.valueOf(role));
        jwtInfoToken.setUserName(claims.get("firstName", String.class));
        return jwtInfoToken;
    }
}
