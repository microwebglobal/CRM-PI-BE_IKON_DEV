package com.example.crmchatbotbackend.service;

import com.example.crmchatbotbackend.dto.LeadDTO;
import com.example.crmchatbotbackend.model.Lead;
import com.example.crmchatbotbackend.model.LeadStatus;
import com.example.crmchatbotbackend.model.User;
import com.example.crmchatbotbackend.repository.LeadRepository;
import com.example.crmchatbotbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private UserRepository userRepository;

    // Utility method to get current logged-in user ID
    private Long getCurrentUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            String email = userDetails.getUsername();
            return userRepository.findByEmail(email)
                    .map(User::getId)
                    .orElse(null);
        }
        return null;
    }

    // Save Lead
    public String saveLead(LeadDTO leadDTO) {
        Lead lead = leadDTO.toEntity(null, null); // pass null for users to avoid setting on creation
        leadRepository.save(lead);
        return "Lead saved successfully.";
    }

    // Get Leads by Session ID
    public List<LeadDTO> getLeadsBySessionId(String sessionId) {
        List<Lead> leads = leadRepository.findBySessionId(sessionId);
        return leads.stream()
                .map(LeadDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Get All Leads
    public List<LeadDTO> getAllLeads() {
        List<Lead> leads = leadRepository.findAll();
        return leads.stream()
                .map(LeadDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Update Lead Status and set user who updated it
    public String updateLeadStatus(Long leadId, LeadStatus status) {
        Optional<Lead> optionalLead = leadRepository.findById(leadId);
        if (optionalLead.isPresent()) {
            Lead lead = optionalLead.get();
            lead.setStatus(status);

            Long currentUserId = getCurrentUserId();
            if (currentUserId != null) {
                User currentUser = userRepository.findById(currentUserId).orElse(null);
                if (currentUser != null) {
                    if (status == LeadStatus.ON_HOLD) {
                        lead.setOnHoldUser(currentUser);
                    } else if (status == LeadStatus.CLOSED) {
                        lead.setClosedUser(currentUser);
                    }
                }
            }

            leadRepository.save(lead);
            return "Lead status updated successfully.";
        } else {
            return "Lead not found.";
        }
    }

    // Delete Lead
    public String deleteLead(Long leadId) {
        if (leadRepository.existsById(leadId)) {
            leadRepository.deleteById(leadId);
            return "Lead deleted successfully.";
        } else {
            return "Lead not found.";
        }
    }

    // Get Lead Count by Status
    public Map<String, Long> getLeadCountByStatus() {
        List<Lead> leads = leadRepository.findAll();
        return leads.stream()
                .collect(Collectors.groupingBy(
                        lead -> lead.getStatus().name(),
                        Collectors.counting()));
    }

    // Get Lead Count by Insurance Type
    public Map<String, Long> getLeadCountByInsuranceType() {
        List<Lead> leads = leadRepository.findAll();
        return leads.stream()
                .collect(Collectors.groupingBy(
                        Lead::getInsuranceType,
                        Collectors.counting()));
    }
}
