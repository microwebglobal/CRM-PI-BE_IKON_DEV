package com.example.crmchatbotbackend.controller;

import com.example.crmchatbotbackend.dto.LoginRequest;
import com.example.crmchatbotbackend.dto.RefreshTokenRequest;
import com.example.crmchatbotbackend.dto.RegisterRequest;
import com.example.crmchatbotbackend.dto.UserResponse;
import com.example.crmchatbotbackend.model.ApprovalStatus;
import com.example.crmchatbotbackend.model.BlacklistedToken;
import com.example.crmchatbotbackend.model.Role;
import com.example.crmchatbotbackend.model.User;
import com.example.crmchatbotbackend.repository.BlacklistedTokenRepository;
import com.example.crmchatbotbackend.repository.UserRepository;
import com.example.crmchatbotbackend.security.JwtUtil;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Calendar;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BlacklistedTokenRepository blacklistedTokenRepository;

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshAccessToken(@RequestBody RefreshTokenRequest request) {
        String refreshToken = request .getRefreshToken();

        try {
            String email = jwtUtil.validateRefreshToken(refreshToken);

            String newAccessToken = jwtUtil.generateAccessToken(email);
            String newRefreshToken = jwtUtil.generateRefreshToken(email);

            return ResponseEntity.ok(Map.of(
                    "accessToken", newAccessToken,
                    "refreshToken", newRefreshToken
            ));
        } catch (JwtException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired refresh token");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest request) {
        // Validate password match
        if (!request.password().equals(request.confirmPassword())) {
            return ResponseEntity.badRequest().body("Passwords do not match.");
        }

        // Check if the email is already registered
        if (userRepository.findByEmail(request.email()).isPresent()) {
            return ResponseEntity.badRequest().body("Email is already registered.");
        }

        // Create new user with all required fields
        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.AGENT)
                .approvalStatus(ApprovalStatus.PENDING)
                .build();

        // Save user
        userRepository.save(user);

        return ResponseEntity.ok("Registration successful. Awaiting admin approval.");
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.email());

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        User user = userOpt.get();

        if (user.getApprovalStatus() != ApprovalStatus.APPROVED) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account not approved yet");
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email(), request.password())
            );

            // ✅ Generate access and refresh tokens
            String accessToken = jwtUtil.generateAccessToken(request.email());
            String refreshToken = jwtUtil.generateRefreshToken(request.email());

            // ✅ Return both tokens
            return ResponseEntity.ok(Map.of(
                    "accessToken", accessToken,
                    "refreshToken", refreshToken
            ));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails userDetails) {
            String email = userDetails.getUsername();
            Optional<User> userOpt = userRepository.findByEmail(email);

            if (userOpt.isPresent()) {
                User user = userOpt.get();
                return ResponseEntity.ok(new UserResponse(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getRole(),
                        user.getApprovalStatus(),
                        user.getCreatedAt(),
                        user.getUpdatedAt()
                ));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid session");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Missing or invalid Authorization header");
        }

        String token = authHeader.substring(7); // Remove "Bearer "

        try {
            // 🛡 Validate and extract expiration (only from access tokens)
            Calendar expiry = jwtUtil.extractAccessTokenExpiration(token);
            Instant expiryInstant = expiry.toInstant();

            // ✅ Blacklist the token to prevent reuse
            blacklistedTokenRepository.save(new BlacklistedToken(token, expiryInstant));

            return ResponseEntity.ok("Logged out successfully");

        } catch (JwtException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid or malformed token: " + e.getMessage());
        }
    }
}
