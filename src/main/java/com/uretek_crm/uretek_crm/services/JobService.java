package com.uretek_crm.uretek_crm.services;

import com.uretek_crm.uretek_crm.model.Job;
import com.uretek_crm.uretek_crm.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //CREATE
    public Job save(Job job){
        return jobRepository.save(job);
    }

    //READ (by ID)
    public Optional<Job> findById(Long id){ return jobRepository.findById(id); }

    //READ (by budget number )
    public Optional<Job> findByBudget(String budget) { return jobRepository.findByBudget(budget); }

    //UPDATE (PUT/CATCH)
    public Job updateJob(Long id, Job updatedJob) {
        Job existingJob = jobRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Job with ID " + id + " not found."));

        if (updatedJob.getBudget() != null) {
            existingJob.setBudget(updatedJob.getBudget());
        }

        if (updatedJob.getDescription() != null){
            existingJob.setDescription(updatedJob.getDescription());
        }

        if (updatedJob.getStatus() != null) {
            existingJob.setStatus(updatedJob.getStatus());
        }

        if (updatedJob.getJobSiteAddress() != null) {
            existingJob.setJobSiteAddress(updatedJob.getJobSiteAddress());
        }



        return jobRepository.save(existingJob);
    }

    //DELETE
    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }



}


