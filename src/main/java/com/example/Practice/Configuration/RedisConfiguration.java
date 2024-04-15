package com.example.Practice.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    final private String hostName;
    final private Integer port;

    public RedisConfiguration(
            @Value("${spring.data.redis.host}") String hostName,
            @Value("${spring.data.redis.port}") Integer port) {
        this.hostName = hostName;
        this.port = port;
    }

    @Bean
    public  JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(hostName);
        jedisConnectionFactory.setPort(port);
        return jedisConnectionFactory;
    }

    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
