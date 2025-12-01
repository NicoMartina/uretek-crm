package com.uretek_crm.uretek_crm.controller;

import com.uretek_crm.uretek_crm.model.JobCategory;
import com.uretek_crm.uretek_crm.services.JobCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class JobCategoryController {
    private final JobCategoryService jobCategoryService;

    public JobCategoryController(JobCategoryService jobCategoryService) {
        this.jobCategoryService = jobCategoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobCategory createCategory(@RequestBody JobCategory category){ return  jobCategoryService.save(category); }

    @GetMapping
    public List<JobCategory> getAllCategories(){ return jobCategoryService.findAll(); }

}
