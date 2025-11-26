package com.uretek_crm.uretek_crm.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // Relationship: Many Visits belong to One Job
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;


    // Visit details
    @Column(nullable = false)
    private LocalDate visitDate;

    private boolean visited = false; // Visited ?

    // Payment Details
    private boolean paid = false; // Paid for the visit ?

    private BigDecimal paymentAmount; // Amount paid for the visit

    private String formOfPayment; //e.g. cash / credit card / debit card

    private String factura; // does he need a bill made to his name ?

    @Lob
    private String comments;




}
