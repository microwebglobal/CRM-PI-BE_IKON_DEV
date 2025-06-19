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

import java.util.Date;
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
        Lead lead = leadDTO.toEntity(null, null);
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

    // Update Lead Status with Remark and Timestamp
    public String updateLeadStatus(Long leadId, LeadStatus status, String remark) {
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
                        lead.setOnHoldRemark(remark);
                        lead.setOnHoldTime(new Date());
                    } else if (status == LeadStatus.CLOSED) {
                        lead.setClosedUser(currentUser);
                        lead.setClosedRemark(remark);
                        lead.setClosedTime(new Date());
                    }
                }
            }

            leadRepository.save(lead);
            return "Lead status and remark updated successfully.";
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
