package com.example.crmchatbotbackend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Calendar;

@Component
public class JwtUtil {

    // Separate keys for access and refresh tokens for extra security
    private final Key accessTokenKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final Key refreshTokenKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    // Token validity durations
    private final long accessTokenExpirationMs = 15 * 60 * 1000;     // 15 minutes
    private final long refreshTokenExpirationMs = 7 * 24 * 60 * 60 * 1000; // 7 days

    // Generate Access Token
    public String generateAccessToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpirationMs))
                .signWith(accessTokenKey)
                .compact();
    }

    // Generate Refresh Token
    public String generateRefreshToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpirationMs))
                .signWith(refreshTokenKey)
                .compact();
    }

    // Validate Access Token and extract subject
    public String validateAccessToken(String token) throws JwtException {
        return Jwts.parserBuilder()
                .setSigningKey(accessTokenKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Validate Refresh Token and extract subject
    public String validateRefreshToken(String token) throws JwtException {
        return Jwts.parserBuilder()
                .setSigningKey(refreshTokenKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Extract expiration date from access token
    public Calendar extractAccessTokenExpiration(String token) throws JwtException {
        Date expirationDate = Jwts.parserBuilder()
                .setSigningKey(accessTokenKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expirationDate);
        return calendar;
    }

    // Optional: Extract expiration from refresh token (if needed)
    public Calendar extractRefreshTokenExpiration(String token) throws JwtException {
        Date expirationDate = Jwts.parserBuilder()
                .setSigningKey(refreshTokenKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expirationDate);
        return calendar;
    }
}
