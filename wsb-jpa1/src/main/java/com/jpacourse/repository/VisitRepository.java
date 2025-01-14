package com.jpacourse.repository;

import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<VisitEntity, Long> {
    List<VisitEntity> findByPatientId(Long patientId);
}
