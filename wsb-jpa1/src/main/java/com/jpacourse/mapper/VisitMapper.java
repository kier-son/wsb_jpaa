package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

public class VisitMapper 
{
    public static VisitTO toVisitTO(VisitEntity entity) 
    {
        if (entity == null) 
        {
            return null;
        }

        VisitTO visitTO = new VisitTO();
        visitTO.setId(entity.getId());
        visitTO.setTime(entity.getTime());
        visitTO.SetDoctor(DoctorMapper.toDoctorTO(entity.getDoctor())); // Map DoctorEntity to DoctorTO
        visitTO.setId(entity.getPatient().getId());

        return visitTO;
    }

    public static VisitEntity toVisitEntity(VisitTO visitTO, DoctorEntity doctor, PatientEntity patient) 
    {
        if (visitTO == null) 
        {
            return null;
        }

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setTime(visitTO.getTime());
        visitEntity.setDoctor(doctor); // Use provided DoctorEntity
        visitEntity.setPatient(patient);

        return visitEntity;
    }
}
