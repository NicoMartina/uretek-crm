package com.uretek_crm.uretek_crm.repository;

import com.uretek_crm.uretek_crm.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
    Optional<Job> findByBudget(Long number);
}
