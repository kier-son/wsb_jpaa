package com.jpacourse.mapper;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.persistence.entity.DoctorEntity;

public class DoctorMapper 
{
    public static DoctorTO toDoctorTO(DoctorEntity entity) 
    {
        if (entity == null) 
        {
            return null;
        }

        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(entity.getId());
        doctorTO.setFirstName(entity.getFirstName());
        doctorTO.setLastName(entity.getLastName());
        doctorTO.setSpecialization(entity.getSpecialization());

        return doctorTO;
    }

    public static DoctorEntity toDoctorEntity(DoctorTO doctorTO) 
    {
        if (doctorTO == null) 
        {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTO.getId());
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setLastName(doctorTO.getLastName());
        doctorEntity.setSpecialization(doctorTO.getSpecialization());

        return doctorEntity;
    }
}
