package com.uretek_crm.uretek_crm.repository;

import com.uretek_crm.uretek_crm.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    // Custom query method: Finds all visits associated with a specific Job ID
    List<Visit> findByJobId(Long jobId);
}
