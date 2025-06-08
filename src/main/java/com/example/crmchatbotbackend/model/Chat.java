package com.example.crmchatbotbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "chat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sessionId;

    @Column
    private String customerEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sender sender;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private User agent; // FK to users

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date timestamp;

    @Column
    private String intent;

    @Column(columnDefinition = "TEXT")
    private String metadata;
}
