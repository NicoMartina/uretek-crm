package com.uretek_crm.uretek_crm.controller;

import com.uretek_crm.uretek_crm.model.Visit;
import com.uretek_crm.uretek_crm.repository.VisitRepository;
import com.uretek_crm.uretek_crm.services.VisitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/visits")
public class VisitController {
    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    //POST /api/v1/visits - CREATE new visit
    @PostMapping
    public ResponseEntity<Visit> createVisit(@RequestBody Visit newVisit){
        Visit savedVisit = visitService.save(newVisit);
        return new ResponseEntity<>(savedVisit, HttpStatus.CREATED);
    }

    // GET /api/v1/visits - READ all visits (use sparingly)
    @GetMapping
    public List<Visit> findAllVisits(){
        return visitService.findAll();
    }

    // GET /api/v1/visits/{visitId} - READ visit by ID
    @GetMapping("/api/v1/{visitId}")
    public ResponseEntity<Visit> getVisitById(@PathVariable Long visitId) {
        return visitService.findById(visitId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET /api/v1/visits?jobId=X - READ visits linked to a specific job
    @GetMapping(params = "jobId")
    public List<Visit> findByJobId(@RequestParam Long jobId) {
        return visitService.findByJobId(jobId);
    }

    // PUT /api/v1/visits/{visitId} - UPDATE existing visit
    public Visit updateVisit(@PathVariable Long visitId, @RequestBody Visit updatedVisit) {
        return visitService.updateVisit(visitId, updatedVisit);
    }

    // DELETE
    @DeleteMapping("/{visitId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVisit(@PathVariable Long visitId){
        visitService.deleteVisit(visitId);
    }
}
