package com.example.crmchatbotbackend.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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

    @Column
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

    // Automatically set the createdAt timestamp
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;
}
