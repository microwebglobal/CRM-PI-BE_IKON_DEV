package com.example.crmchatbotbackend.controller;

import com.example.crmchatbotbackend.dto.ChatDTO;
import com.example.crmchatbotbackend.model.Chat;
import com.example.crmchatbotbackend.model.User;
import com.example.crmchatbotbackend.repository.ChatRepository;
import com.example.crmchatbotbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String saveChatMessage(@RequestBody ChatDTO request) {
        User agent = null;

        if (request.getAgentId() != null) {
            agent = userRepository.findById(request.getAgentId()).orElse(null);
        }

        Chat chat = request.toEntity(agent);
        chatRepository.save(chat);

        return "Chat message saved successfully.";
    }

    @GetMapping("/conversation/{sessionId}")
    public List<ChatDTO> getChatHistory(@PathVariable String sessionId) {
        List<Chat> chatList = chatRepository.findBySessionIdOrderByTimestampAsc(sessionId);
        return chatList.stream()
                .map(ChatDTO::fromEntity)
                .toList();
    }

}