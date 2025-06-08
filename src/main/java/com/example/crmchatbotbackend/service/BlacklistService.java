package com.example.crmchatbotbackend.service;

import com.example.crmchatbotbackend.repository.BlacklistedTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlacklistService {

    private final BlacklistedTokenRepository blacklistedTokenRepository;

    public boolean isBlacklisted(String token) {
        return blacklistedTokenRepository.existsByToken(token);
    }
}
