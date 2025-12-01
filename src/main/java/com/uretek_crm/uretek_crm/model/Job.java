package com.uretek_crm.uretek_crm.model;

import com.uretek_crm.uretek_crm.model.enums.JobStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

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

    // --- Inventory/Product Tracking (New) ---
    private BigDecimal productusedQuantity;
    private String productUsedUnit; // e.g. "kg", "liters", "units"

    // --- Reporting/Stats Categories (NNew) ---
    // Links this job to multiple categories (e.g., "Repair" and "Residential")
    @ManyToMany
    @JoinTable(
            name = "job_category_link", // The name of the intermediate join table
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<JobCategory> categories;

    @ManyToOne // Many Jobs belong to One Contact
    @JoinColumn(name = "contact_id") // This specifies the foreign key column name
    private Contact contact;


}
