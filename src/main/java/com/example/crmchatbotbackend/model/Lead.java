package com.example.crmchatbotbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "leads")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sessionId;

    @Column(nullable = false)
    private String insuranceType;

    @Column
    private String fullName;

    @Column
    private String email;

    @Column
    private String contactNumber;

    @Column
    private String destination;

    @Column
    private String travelDates;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date timestamp;

    @Column
    private String travellerAge;

    @Column
    private String vehicleModel;

    @Column
    private String vehicleNumber;

    @Column
    private String yearOfManufacture;

    @Column
    private String usageType;

    @Column
    private String estimatedValue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LeadStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "on_hold_user_id")
    private User onHoldUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "closed_user_id")
    private User closedUser;
}
