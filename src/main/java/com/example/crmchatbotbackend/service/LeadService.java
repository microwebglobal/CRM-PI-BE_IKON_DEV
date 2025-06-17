package com.example.crmchatbotbackend.service;

import com.example.crmchatbotbackend.dto.LeadDTO;
import com.example.crmchatbotbackend.model.Lead;
import com.example.crmchatbotbackend.model.LeadStatus;
import com.example.crmchatbotbackend.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Async
    public CompletableFuture<String> saveLead(LeadDTO leadDTO) {
        Lead lead = leadDTO.toEntity();
        leadRepository.save(lead);
        return CompletableFuture.completedFuture("Lead saved successfully.");
    }

    @Async
    public CompletableFuture<List<LeadDTO>> getLeadsBySessionId(String sessionId) {
        List<Lead> leads = leadRepository.findBySessionId(sessionId);
        List<LeadDTO> leadDTOs = leads.stream()
                .map(LeadDTO::fromEntity)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(leadDTOs);
    }

    @Async
    public CompletableFuture<List<LeadDTO>> getAllLeads() {
        List<Lead> leads = leadRepository.findAll();
        List<LeadDTO> leadDTOs = leads.stream()
                .map(LeadDTO::fromEntity)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(leadDTOs);
    }

    @Async
    public CompletableFuture<String> updateLeadStatus(Long leadId, LeadStatus status) {
        Optional<Lead> optionalLead = leadRepository.findById(leadId);
        if (optionalLead.isPresent()) {
            Lead lead = optionalLead.get();
            lead.setStatus(status);
            leadRepository.save(lead);
            return CompletableFuture.completedFuture("Lead status updated successfully.");
        } else {
            return CompletableFuture.completedFuture("Lead not found.");
        }
    }

    @Async
    public CompletableFuture<String> deleteLead(Long leadId) {
        if (leadRepository.existsById(leadId)) {
            leadRepository.deleteById(leadId);
            return CompletableFuture.completedFuture("Lead deleted successfully.");
        } else {
            return CompletableFuture.completedFuture("Lead not found.");
        }
    }

    @Async
    public CompletableFuture<Map<String, Long>> getLeadCountByStatus() {
        List<Lead> leads = leadRepository.findAll();
        Map<String, Long> result = leads.stream()
                .collect(Collectors.groupingBy(
                        lead -> lead.getStatus().name(),
                        Collectors.counting()
                ));
        return CompletableFuture.completedFuture(result);
    }

    @Async
    public CompletableFuture<Map<String, Long>> getLeadCountByInsuranceType() {
        List<Lead> leads = leadRepository.findAll();
        Map<String, Long> result = leads.stream()
                .collect(Collectors.groupingBy(
                        Lead::getInsuranceType,
                        Collectors.counting()
                ));
        return CompletableFuture.completedFuture(result);
    }
}
