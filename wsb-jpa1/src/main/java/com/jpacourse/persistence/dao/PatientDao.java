package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.dao.impl.AbstractDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

public interface PatientDao extends Dao<PatientEntity, Long> {
    VisitEntity addVisitToPatient(Long patientId, Long doctorId,
                                  LocalDateTime visitTime,
                                  String visitDescription);
}

