package com.capgemini.wsb.mapper;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import java.util.stream.Collectors;
public final class PatientMapper {
    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setAge(patientEntity.getAge());
        if (patientEntity.getVisits() != null) {
            patientTO.setVisits(patientEntity.getVisits().stream()
                    .map(VisitMapper::mapToTO)
                    .collect(Collectors.toList()));
        }
        if (patientEntity.getAddresses() != null) {
            patientTO.setAddresses(patientEntity.getAddresses().stream()
                    .map(AddressMapper::mapToTO)
                    .collect(Collectors.toList()));
        }
        return patientTO;
    }
    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }
        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setAge(patientTO.getAge());
        if (patientTO.getVisits() != null) {
            patientEntity.setVisits(patientTO.getVisits().stream()
                    .map(VisitMapper::mapToEntity)
                    .collect(Collectors.toSet()));
        }
        if (patientTO.getAddresses() != null) {
            patientEntity.setAddresses(patientTO.getAddresses().stream()
                    .map(AddressMapper::mapToEntity)
                    .collect(Collectors.toSet()));
        }
        return patientEntity;
    }
}