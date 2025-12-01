package com.uretek_crm.uretek_crm.services;


import com.uretek_crm.uretek_crm.model.JobCategory;
import com.uretek_crm.uretek_crm.repository.JobCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoryService {
    private final JobCategoryRepository jobCategoryRepository;

    public JobCategoryService(JobCategoryRepository jobCategoryRepository) {
        this.jobCategoryRepository = jobCategoryRepository;
    }

    public JobCategory save(JobCategory category){ return jobCategoryRepository.save(category); }
    public List<JobCategory> findAll(){ return  jobCategoryRepository.findAll(); }
}
