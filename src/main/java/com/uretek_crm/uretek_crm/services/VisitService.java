package com.uretek_crm.uretek_crm.services;

import com.uretek_crm.uretek_crm.model.Visit;
import com.uretek_crm.uretek_crm.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitService {
    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    //CREATE / UPDATE (save)
    public Visit save(Visit visit){
        // NOTE: In a future phase, you'd add logic here to update the parent Job's status
        // to VISIT_COMPLETED or VISIT_PAID after saving.
        return visitRepository.save(visit);
    }

    // READ ALL
    public List<Visit> findAll(){
        return visitRepository.findAll();
    }

    // READ BY ID
    public Optional<Visit> findById(Long id){
        return visitRepository.findById(id);
    }

    // READ by Job ID (Crucial for linking visits to a job)
    public List<Visit> findByJobId(Long jobId) {
        return visitRepository.findByJobId(jobId);
    }

    // DELETE
    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }

    // UPDATE - Simple replacement PUT logic
    public Visit updateVisit(Long id, Visit updatedVisit) {
        return visitRepository.findById(id)
                .map(existingVisit -> {
                    // Ensure the ID of the updated object matches the path variable
                    updatedVisit.setId(id);
                    return visitRepository.save(updatedVisit);
                })
                .orElseThrow(() -> new IllegalArgumentException("Visit with ID " + id + " does not exist."));
    }
}
