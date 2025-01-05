package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.dao.impl.AbstractDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    public VisitEntity addVisitToPatient(Long patientId, Long doctorId,
                                         LocalDateTime visitTime,
                                         String visitDescription) {
        // Pobierz pacjenta i lekarza
        PatientEntity patient = findOne(patientId);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);

        // Utwórz nową wizytę
        VisitEntity visit = new VisitEntity();
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setTime(visitTime);
        visit.setDescription(visitDescription);

        // Utwórz leczenie
        MedicalTreatmentEntity treatment = new MedicalTreatmentEntity();
        treatment.setType(TreatmentType.USG);
        treatment.setDescription("Standardowe badanie");
        visit.setMedicalTreatment(treatment);

        // Dodaj wizytę do pacjenta
        patient.getVisits().add(visit);

        // Zaktualizuj pacjenta
        merge(patient);
        
        return visit;
    }

    private void merge(PatientEntity patient) {
    }
}
