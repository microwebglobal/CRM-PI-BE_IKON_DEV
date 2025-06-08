package com.example.crmchatbotbackend.repository;

import com.example.crmchatbotbackend.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    // Optional: Get all chats for a specific session
    List<Chat> findBySessionId(String sessionId);

    // Optional: Get all chats for a specific customer
    List<Chat> findByCustomerEmail(String customerEmail);

    // Optional: Get all chats by sessionId ordered by timestamp
    List<Chat> findBySessionIdOrderByTimestampAsc(String sessionId);
}
