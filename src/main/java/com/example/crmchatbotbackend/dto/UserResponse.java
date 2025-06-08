package com.example.crmchatbotbackend.dto;

import com.example.crmchatbotbackend.model.ApprovalStatus;
import com.example.crmchatbotbackend.model.Role;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        Role role,
        ApprovalStatus approvalStatus,
        java.util.Date createdAt,
        java.util.Date updatedAt
) {}
