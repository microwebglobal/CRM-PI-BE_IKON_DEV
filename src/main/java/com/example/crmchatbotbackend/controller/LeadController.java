package com.example.crmchatbotbackend.controller;

import com.example.crmchatbotbackend.dto.LeadDTO;
import com.example.crmchatbotbackend.model.Lead;
import com.example.crmchatbotbackend.model.LeadStatus;
import com.example.crmchatbotbackend.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadRepository leadRepository;

    // Save Lead
    @PostMapping
    public String saveLead(@RequestBody LeadDTO leadDTO) {
        Lead lead = leadDTO.toEntity();
        leadRepository.save(lead);
        return "Lead saved successfully.";
    }

    // Get Leads by Session ID
    @GetMapping("/{sessionId}")
    public List<LeadDTO> getLeadsBySessionId(@PathVariable String sessionId) {
        List<Lead> leads = leadRepository.findBySessionId(sessionId);
        return leads.stream()
                .map(LeadDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Get All Leads
    @GetMapping
    public List<LeadDTO> getAllLeads() {
        List<Lead> leads = leadRepository.findAll();
        return leads.stream()
                .map(LeadDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Update Lead Status
    @PutMapping("/{leadId}/status")
    public String updateLeadStatus(@PathVariable Long leadId, @RequestParam LeadStatus status) {
        Optional<Lead> optionalLead = leadRepository.findById(leadId);
        if (optionalLead.isPresent()) {
            Lead lead = optionalLead.get();
            lead.setStatus(status);
            leadRepository.save(lead);
            return "Lead status updated successfully.";
        } else {
            return "Lead not found.";
        }
    }

    // Delete Lead by ID
    @DeleteMapping("/{leadId}")
    public String deleteLead(@PathVariable Long leadId) {
        if (leadRepository.existsById(leadId)) {
            leadRepository.deleteById(leadId);
            return "Lead deleted successfully.";
        } else {
            return "Lead not found.";
        }
    }
}
