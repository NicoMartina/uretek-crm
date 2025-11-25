package com.uretek_crm.uretek_crm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobReference;
    private String budget;
    private String description;

    @Enumerated(EnumType.STRING) // Ensures the Enum is stored as a readable string
    private JobStatus status;
    
    private String address;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    @ManyToOne // Many Jobs belong to One Contact
    @JoinColumn(name = "contact_id") // This specifies the foreign key column name
    private Contact contact;


}
