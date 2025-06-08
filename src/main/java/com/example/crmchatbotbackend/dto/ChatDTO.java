package com.example.crmchatbotbackend.dto;

import com.example.crmchatbotbackend.model.Chat;
import com.example.crmchatbotbackend.model.Sender;
import com.example.crmchatbotbackend.model.User;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatDTO {

    private Long id;
    private String sessionId;
    private String customerEmail;
    private Sender sender;
    private Long agentId; // Instead of User object, just the agent's ID
    private String message;
    private Date timestamp;
    private String intent;
    private String metadata;

    // Convert from Entity to DTO
    public static ChatDTO fromEntity(Chat chat) {
        return ChatDTO.builder()
                .id(chat.getId())
                .sessionId(chat.getSessionId())
                .customerEmail(chat.getCustomerEmail())
                .sender(chat.getSender())
                .agentId(chat.getAgent() != null ? chat.getAgent().getId() : null)
                .message(chat.getMessage())
                .timestamp(chat.getTimestamp())
                .intent(chat.getIntent())
                .metadata(chat.getMetadata())
                .build();
    }

    // Convert from DTO to Entity
    public Chat toEntity(User agent) {
        return Chat.builder()
                .sessionId(this.sessionId)
                .customerEmail(this.customerEmail)
                .sender(this.sender)
                .agent(agent)
                .message(this.message)
                .timestamp(this.timestamp != null ? this.timestamp : new Date())
                .intent(this.intent)
                .metadata(this.metadata)
                .build();
    }
}
