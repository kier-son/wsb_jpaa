package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    VisitEntity addVisitToPatient(Long patientId, Long doctorId,
                                  LocalDateTime visitTime,
                                  String visitDescription);

    public List<PatientEntity> FindPatientsWithMoreThanXVisits(long visitCount);
    
    public List<PatientEntity> FindByLastName(String value);
    
    public List<PatientEntity> FindByHealthScore(Integer healthScore);
}

