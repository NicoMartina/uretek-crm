package com.uretek_crm.uretek_crm.model;

public enum JobStatus {
    LEAD("Lead (Initial Contact)"),
    QUOTE_SENT("Quote Sent"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    CANCELED("Canceled");

    private final String displayValue;

    JobStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}