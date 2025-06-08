package com.example.crmchatbotbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.time.Instant;

@Entity
@Table(name = "blacklisted_tokens")
public class BlacklistedToken {

    @Id
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;

    public BlacklistedToken() {
    }

    public BlacklistedToken(String token, Instant expiryDate) {
        this.token = token;
        this.expiryDate = expiryDate;
    }

    public String getToken() {
        return token;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }
}
