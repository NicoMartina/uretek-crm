package com.uretek_crm.uretek_crm.model;

import com.uretek_crm.uretek_crm.model.enums.JobStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Consultation/Lead Fields ---
    private LocalDateTime contactDate;

    @Lob
    private String problemDescription;
    private String howHeard;
    private String jobSiteAddress;

    // --- Financial/Quote Data ---
    private String jobReference;
    private BigDecimal budget;

    // --- Workflow Status ---
    @Enumerated(EnumType.STRING)
    private JobStatus status;

    // --- Excecution Data ---
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne // Many Jobs belong to One Contact
    @JoinColumn(name = "contact_id") // This specifies the foreign key column name
    private Contact contact;


}
