package com.example.crmchatbotbackend.repository;

import com.example.crmchatbotbackend.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, Long> {
    List<Lead> findBySessionId(String sessionId);
}
