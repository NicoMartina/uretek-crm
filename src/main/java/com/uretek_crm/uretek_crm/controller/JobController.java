package com.uretek_crm.uretek_crm.controller;

import com.uretek_crm.uretek_crm.model.Job;
import com.uretek_crm.uretek_crm.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Job createJob(@RequestBody Job newJob) {
        return jobService.save(newJob);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId) {
        Optional<Job> job = jobService.findById(jobId);
        return job.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(params = "budget")
    public ResponseEntity<Job> getJobByBudget(@RequestParam String budget) {
        Optional<Job> job = jobService.findByBudget(budget);
        return job.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{jobId}")
    public Job updateJob(@PathVariable Long jobId, @RequestBody Job updatedJob) {
        return jobService.updateJob(jobId, updatedJob);
    }

    @DeleteMapping("/{jobId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteJob(@PathVariable Long id){
        jobService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
