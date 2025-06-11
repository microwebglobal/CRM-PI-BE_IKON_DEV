package com.example.crmchatbotbackend.repository;

import com.example.crmchatbotbackend.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;  // <-- Import Query here
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findBySessionId(String sessionId);

    List<Chat> findByCustomerEmail(String customerEmail);

    List<Chat> findBySessionIdOrderByTimestampAsc(String sessionId);

    @Query(value = """
        SELECT c1.*
        FROM chat c1
        INNER JOIN (
            SELECT session_id, MIN(timestamp) AS min_time
            FROM chat
            GROUP BY session_id
        ) c2 ON c1.session_id = c2.session_id AND c1.timestamp = c2.min_time
        """, nativeQuery = true)
    List<Chat> findFirstChatPerSession();
}

