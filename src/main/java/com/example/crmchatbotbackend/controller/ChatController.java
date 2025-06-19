package com.example.crmchatbotbackend.controller;

import com.example.crmchatbotbackend.dto.ChatDTO;
import com.example.crmchatbotbackend.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public String saveChatMessage(@RequestBody ChatDTO request) {
        chatService.saveChat(request); // Non-blocking call
        return "Chat processing started.";
    }

    @GetMapping("/conversation/{sessionId}")
    public List<ChatDTO> getChatHistory(@PathVariable("sessionId") String sessionId) {
        return chatService.getChatHistory(sessionId);
    }

    @GetMapping("/first-per-session")
    public List<ChatDTO> getFirstChatPerSession() {
        return chatService.getFirstChatPerSession();
    }
}
