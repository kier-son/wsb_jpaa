package com.jpacourse.service.impl;

import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {
    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<VisitEntity> findVisitsByPatientId(Long patientId) {
        return visitRepository.findByPatientId(patientId);
    }
}
