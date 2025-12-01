package com.uretek_crm.uretek_crm.model.enums;

public enum JobStatus {
    // 1. LEAD / CONSULTATION STAGE
    LEAD_NEW("New Consultation Lead"),
    LEAD_CONTACTED("Lead Contacted - Awaiting Visit Booking"),

    // 2. VISIT / QUALIFICATION STAGE
    VISIT_BOOKED("Visit Scheduled"),
    VISIT_COMPLETED("Visit Completed - Awaiting Budget"),
    VISIT_PAID("Visit Paid"),

    // 3. BUDGET / QUOTE STAGE
    QUOTE_SENT("Budget Sent to Client"),
    QUOTE_ACCEPTED("Budget Accepted - Awaiting Down Payment"),
    QUOTE_REJECTED("Budget Rejected"),

    // 4. JOB EXECUTION STAGE
    JOB_SCHEDULED("Job Scheduled"),
    JOB_IN_PROGRESS("Job Currently In Progress"),
    JOB_FINISHED("Job Finished - Awaiting Final Payment"),

    // FINAL STATES
    LOST("Lost Lead/Job"),
    CANCELED("Canceled");

    private final String displayValue;

    JobStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}