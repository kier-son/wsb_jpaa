package com.capgemini.wsb.mapper;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import java.util.stream.Collectors;
public final class DoctorMapper {
    public static DoctorTO mapToTO(final DoctorEntity doctorEntity) {
        if (doctorEntity == null) {
            return null;
        }
        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());
        if (doctorEntity.getVisits() != null) {
            doctorTO.setVisitIds(doctorEntity.getVisits().stream().map(visit -> visit.getId()).collect(Collectors.toList()));
        }
        if (doctorEntity.getAddresses() != null) {
            doctorTO.setAddresses(doctorEntity.getAddresses().stream().map(AddressMapper::mapToTO).collect(Collectors.toList()));
        }
        return doctorTO;
    }
    public static DoctorEntity mapToEntity(final DoctorTO doctorTO) {
        if (doctorTO == null) {
            return null;
        }
        final DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTO.getId());
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setLastName(doctorTO.getLastName());
        doctorEntity.setTelephoneNumber(doctorTO.getTelephoneNumber());
        doctorEntity.setEmail(doctorTO.getEmail());
        doctorEntity.setDoctorNumber(doctorTO.getDoctorNumber());
        doctorEntity.setSpecialization(doctorTO.getSpecialization());
        return doctorEntity;
    }
}