package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    
    @Override
    public VisitEntity addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitTime, String visitDescription) 
    {
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

    private void merge(PatientEntity patient) 
    {
        entityManager.merge(patient);
    }

    @Override
    public List<PatientEntity> FindByLastName(String lastName) 
    {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName).getResultList();
    }

    @Override
    public List<PatientEntity> FindPatientsWithMoreThanXVisits(long visitCount) 
    {
        return entityManager.createQuery("SELECT p FROM PatientEntity p JOIN p.visits v GROUP BY p " + 
                        "HAVING COUNT(v) > :visitCount", PatientEntity.class)
                        .setParameter("visitCount", visitCount).getResultList();
    }

    @Override
    public List<PatientEntity> FindByHealthScore(Integer healthScore) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.healthScore = :healthScore", PatientEntity.class)
                .setParameter("healthScore", healthScore).getResultList();
    }
}
