package com.example.Practice.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class Redis {

    private final JedisPool jedisPool = new JedisPool("127.0.0.1", 6333);
    private Jedis jedis = jedisPool.getResource();

    public List<String> getRefreshTokenByLogin(String login) {
        return jedis.lrange(login, 0, -1);
    }

    public void deleteOldTokenAndSaveNewToken(String oldRefreshToken, String newRefreshToken, String login) {
            jedis.lrem(login, 0, oldRefreshToken);
            jedis.lpush(login, newRefreshToken);
            jedis.expire(login, 10800);
    }

    public void setRefreshTokenByLogin (String login, String refreshToken) {
            jedis.lpush(login, refreshToken);
            jedis.expire(login, 10800);
    }
}
