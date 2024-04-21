package com.example.Practice.Service;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class Redis {

    private RedisTemplate<String, String> template;

    public String getRefreshTokenByLogin(String login) {
        return template.boundValueOps(login).get();
    }

    public void setRefreshTokenByLogin (String login, String refreshToken) {
        template.opsForValue().set(login, refreshToken);
        template.expire(login, 3, TimeUnit.HOURS);
    }
}