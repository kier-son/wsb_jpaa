package com.jpacourse.service;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Specialization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest 
{
    /*@SpringBootTest
    @Transactional
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
    class PatientServiceImplTest {

        @Autowired
        private PatientService patientService;

        @Autowired
        private PatientDao patientDao;

        @Autowired
        private VisitDao visitDao;

        @Autowired
        private DoctorDao doctorDao;

        @Test
        void deletePatientById_shouldCascadeDeleteVisitsButNotDoctors() {
            // Arrange: Create patient with visits and doctors
            DoctorEntity doctor = new DoctorEntity();
            doctor.setFirstName("John");
            doctor.setLastName("Doe");
            doctor.setSpecialization(Specialization.DERMATOLOGIST);
            doctorDao.save(doctor);

            var patient = new PatientTO();
            patient.setFirstName("Jane");
            patient.setLastName("Doe");
            patient = patientService.AddPatient(patient);

            VisitEntity visit = new VisitEntity();
            visit.setTime(LocalDateTime.now());
            visit.setDoctor(doctor);
            visit.setPatient(patient);
            visitDao.save(visit);

            // Act: Delete patient
            patientService.deletePatientById(patient.getId());

            // Assert: Verify cascading delete
            assertNotNull("Patient should be deleted.", patientService.findPatientById(patient.getId()));
            assertTrue(visitDao.findAllByPatientId(patient.getId()).isEmpty(), "Visits should be deleted.");
            assertTrue(doctorDao.existsById(doctor.getId()), "Doctor should not be deleted.");
        }

        @Test
        void findPatientById_shouldReturnPatientTOWithCorrectHealthScore() {
            // Arrange: Create patient with visits
            PatientEntity patient = new PatientEntity();
            patient.setFirstName("Jane");
            patient.setLastName("Doe");
            patient.setHealthScore(85); // Expected health score
            patientDao.save(patient);

            VisitEntity visit = new VisitEntity();
            visit.setTime(LocalDateTime.now());
            visit.setPatient(patient);
            visitDao.save(visit);

            // Act: Fetch patient by ID
            PatientTO result = patientService.findPatientById(patient.getId());

            // Assert: Validate PatientTO structure
            assertNotNull(result, "PatientTO should not be null.");
            assertEquals(patient.getFirstName(), result.getFirstName(), "First name should match.");
            assertEquals(patient.getHealthScore(), result.getHealthScore(), "Health score should match.");
            assertNotNull(result.getVisits(), "Visits should not be null.");
            assertFalse(result.getVisits().isEmpty(), "Visits should not be empty.");
        }
    }*/

}