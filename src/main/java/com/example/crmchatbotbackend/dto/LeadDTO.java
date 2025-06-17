package com.example.crmchatbotbackend.dto;

import com.example.crmchatbotbackend.model.Lead;
import com.example.crmchatbotbackend.model.LeadStatus;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeadDTO {

    private Long id;
    private String sessionId;
    private String insuranceType;
    private String fullName;
    private String contactNumber;
    private String email;
    private String destination;
    private String travelDates;
    private Date timestamp;
    private String travellerAge;
    private String vehicleModel;
    private String vehicleNumber;
    private String yearOfManufacture;
    private String usageType;
    private String estimatedValue;
    private LeadStatus status;

    // Convert DTO to Entity
    public Lead toEntity() {
        return Lead.builder()
                .id(this.id)
                .sessionId(this.sessionId)
                .insuranceType(this.insuranceType)
                .fullName(this.fullName)
                .contactNumber(this.contactNumber)
                .email(this.email)
                .destination(this.destination)
                .travelDates(this.travelDates)
                .timestamp(this.timestamp != null ? this.timestamp : new Date())
                .travellerAge(this.travellerAge)
                .vehicleModel(this.vehicleModel)
                .vehicleNumber(this.vehicleNumber)
                .yearOfManufacture(this.yearOfManufacture)
                .usageType(this.usageType)
                .estimatedValue(this.estimatedValue)
                .status(this.status)
                .build();
    }

    // Convert Entity to DTO
    public static LeadDTO fromEntity(Lead lead) {
        if (lead == null) {
            return null;
        }

        return LeadDTO.builder()
                .id(lead.getId())
                .sessionId(lead.getSessionId())
                .insuranceType(lead.getInsuranceType())
                .fullName(lead.getFullName())
                .contactNumber(lead.getContactNumber())
                .email(lead.getEmail())
                .destination(lead.getDestination())
                .travelDates(lead.getTravelDates())
                .timestamp(lead.getTimestamp())
                .travellerAge(lead.getTravellerAge())
                .vehicleModel(lead.getVehicleModel())
                .vehicleNumber(lead.getVehicleNumber())
                .yearOfManufacture(lead.getYearOfManufacture())
                .usageType(lead.getUsageType())
                .estimatedValue(lead.getEstimatedValue())
                .status(lead.getStatus())
                .build();
    }
}