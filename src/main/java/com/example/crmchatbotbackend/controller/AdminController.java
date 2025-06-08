package com.example.crmchatbotbackend.controller;

import com.example.crmchatbotbackend.model.ApprovalStatus;
import com.example.crmchatbotbackend.model.User;
import com.example.crmchatbotbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserRepository userRepository;

    @PatchMapping("/users/{id}/approve")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> approveUser(@PathVariable Long id) {
        return userRepository.findById(id).map(user -> {
            if (user.getApprovalStatus() == ApprovalStatus.APPROVED) {
                return ResponseEntity
                        .badRequest()
                        .body("User is already approved.");
            }

            user.setApprovalStatus(ApprovalStatus.APPROVED);
            userRepository.save(user);
            return ResponseEntity.ok("User approved successfully.");
        }).orElse(ResponseEntity.notFound().build());
    }
}
