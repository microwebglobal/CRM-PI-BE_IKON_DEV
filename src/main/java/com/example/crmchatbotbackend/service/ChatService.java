package com.example.crmchatbotbackend.service;

import com.example.crmchatbotbackend.dto.ChatDTO;
import com.example.crmchatbotbackend.model.Chat;
import com.example.crmchatbotbackend.model.User;
import com.example.crmchatbotbackend.repository.ChatRepository;
import com.example.crmchatbotbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    @Async
    public void saveChatAsync(ChatDTO request) {
        User agent = null;

        if (request.getAgentId() != null) {
            agent = userRepository.findById(request.getAgentId()).orElse(null);
        }

        Chat chat = request.toEntity(agent);
        chatRepository.save(chat);

        System.out.println("Chat saved by thread: " + Thread.currentThread().getName());
    }

    public List<ChatDTO> getChatHistory(String sessionId) {
        List<Chat> chatList = chatRepository.findBySessionIdOrderByTimestampAsc(sessionId);
        return chatList.stream()
                .map(ChatDTO::fromEntity)
                .toList();
    }

    public List<ChatDTO> getFirstChatPerSession() {
        List<Chat> chats = chatRepository.findFirstChatPerSession();
        return chats.stream()
                .map(ChatDTO::fromEntity)
                .toList();
    }
}
