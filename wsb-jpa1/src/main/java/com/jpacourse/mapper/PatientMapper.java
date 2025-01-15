package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.TreatmentTypeTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.util.Collections;
import java.util.stream.Collectors;

public class PatientMapper {
    public static PatientTO mapToTO(PatientEntity patient) {
        if (patient == null) 
            return null;

        PatientTO patientTO = new PatientTO();
        patientTO.setId(patient.getId());
        patientTO.setFirstName(patient.getFirstName());
        patientTO.setLastName(patient.getLastName());
        patientTO.setTelephoneNumber(patient.getTelephoneNumber());
        patientTO.setEmail(patient.getEmail());
        patientTO.setPatientNumber(patient.getPatientNumber());
        patientTO.setDateOfBirth(patient.getDateOfBirth());
        patientTO.setHealthScore(patient.getHealthScore());

        patientTO.setVisits(patient.getVisits().stream()
                .map(visit -> {
                    VisitTO visitTO = new VisitTO();
                    visitTO.setId(visit.getId());
                    visitTO.setTime(visit.getTime());
                    visitTO.setDoctorFirstName(visit.getDoctor().getFirstName());
                    visitTO.setDoctorLastName(visit.getDoctor().getLastName());

                    // Mapowanie typów leczenia
                    if (visit.getMedicalTreatment() != null) {
                        TreatmentTypeTO treatmentTO = new TreatmentTypeTO();
                        treatmentTO.setType(visit.getMedicalTreatment().getType());
                        treatmentTO.setDescription(visit.getMedicalTreatment().getDescription());
                        visitTO.setTreatmentTypes(Collections.singletonList(treatmentTO));
                    }

                    return visitTO;
                })
                .collect(Collectors.toList())
        );

        return patientTO;
    }
    
    public static PatientEntity MapToEntity(PatientTO patientTO) 
    {
        if (patientTO == null) 
            return null;

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setHealthScore(patientTO.getHealthScore());

        patientEntity.setVisits(patientTO.getVisits().stream()
                .map(visitTO -> VisitMapper.toVisitEntity(visitTO,
                        DoctorMapper.toDoctorEntity(visitTO.GetDoctor()), patientEntity)).collect(Collectors.toList()));

        return patientEntity;
    }
}