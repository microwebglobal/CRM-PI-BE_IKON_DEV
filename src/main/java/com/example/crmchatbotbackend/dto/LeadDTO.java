package com.example.crmchatbotbackend.dto;

import com.example.crmchatbotbackend.model.Lead;
import com.example.crmchatbotbackend.model.LeadStatus;
import com.example.crmchatbotbackend.model.User;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private Long onHoldUserId;
    private Long closedUserId;

    // Convert DTO to Entity
    public Lead toEntity(User onHoldUser, User closedUser) {
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
                .onHoldUser(onHoldUser)
                .closedUser(closedUser)
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
                .onHoldUserId(lead.getOnHoldUser() != null ? lead.getOnHoldUser().getId() : null)
                .closedUserId(lead.getClosedUser() != null ? lead.getClosedUser().getId() : null)
                .build();
    }
}
