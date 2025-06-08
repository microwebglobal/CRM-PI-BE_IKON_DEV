package com.example.crmchatbotbackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @Email String email,
        @Size(min = 8, message = "Password must be at least 8 characters") String password,
        @NotBlank String confirmPassword
) {}
