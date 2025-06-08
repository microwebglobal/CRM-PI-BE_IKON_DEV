package com.example.crmchatbotbackend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RedisBlacklistService {

    private final StringRedisTemplate redisTemplate;

    public void blacklistToken(String token, long expirationMs) {
        redisTemplate.opsForValue().set(token, "BLACKLISTED", Duration.ofMillis(expirationMs));
    }

    public boolean isBlacklisted(String token) {
        return redisTemplate.hasKey(token);
    }
}
