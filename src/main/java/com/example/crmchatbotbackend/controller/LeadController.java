package com.example.crmchatbotbackend.controller;

import com.example.crmchatbotbackend.dto.LeadDTO;
import com.example.crmchatbotbackend.model.LeadStatus;
import com.example.crmchatbotbackend.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping
    public CompletableFuture<String> saveLead(@RequestBody LeadDTO leadDTO) {
        return leadService.saveLead(leadDTO);
    }

    @GetMapping("/{sessionId}")
    public CompletableFuture<List<LeadDTO>> getLeadsBySessionId(@PathVariable String sessionId) {
        return leadService.getLeadsBySessionId(sessionId);
    }

    @GetMapping
    public CompletableFuture<List<LeadDTO>> getAllLeads() {
        return leadService.getAllLeads();
    }

    @PutMapping("/{leadId}/status")
    public CompletableFuture<String> updateLeadStatus(@PathVariable Long leadId, @RequestParam LeadStatus status) {
        return leadService.updateLeadStatus(leadId, status);
    }

    @DeleteMapping("/{leadId}")
    public CompletableFuture<String> deleteLead(@PathVariable Long leadId) {
        return leadService.deleteLead(leadId);
    }

    @GetMapping("/count-by-status")
    public CompletableFuture<Map<String, Long>> getLeadCountByStatus() {
        return leadService.getLeadCountByStatus();
    }

    @GetMapping("/count-by-insurance")
    public CompletableFuture<Map<String, Long>> getLeadCountByInsuranceType() {
        return leadService.getLeadCountByInsuranceType();
    }
}
