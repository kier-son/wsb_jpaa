package com.jpacourse.dao;

//import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PatientDaoTest {
    /*@Autowired
    private PatientDao patientDao;
    //@Autowired
    //private DoctorDao doctorDao;

    @Test
    public void testAddVisitToPatient() 
    {
        // Pobierz istniejącego pacjenta i lekarza z bazy
        PatientEntity patient = patientDao.findOne(1L);
        DoctorEntity doctor = doctorDao.findOne(1L);

        int initialVisitsCount = patient.getVisits().size();

        // Dodaj wizytę
        VisitEntity newVisit = patientDao.addVisitToPatient(
                patient.getId(),
                doctor.getId(),
                LocalDateTime.now(),
                "Testowa wizyta"
        );

        // Odśwież pacjenta
        patient = patientDao.findOne(patient.getId());

        // Sprawdź rezultat
        assertThat(VisitEntity.getVisits()).hasSize(initialVisitsCount + 1);
        assertThat(newVisit).isNotNull();
        assertThat(newVisit.getPatient()).isEqualTo(patient);
        assertThat(newVisit.getDoctor()).isEqualTo(doctor);
    }

    @Test
    void testFindByLastName() {
        List<PatientEntity> patients = patientRepository.findByLastName("Doe");
        assertEquals(1, patients.size());
        assertEquals("Jan", patients.get(0).getFirstName());
    }

    @Test
    @Transactional
    void testOptimisticLock() {
        PatientEntity patient1 = patientRepository.findById(1L).orElseThrow();
        PatientEntity patient2 = patientRepository.findById(1L).orElseThrow();

        patient1.setLastName("UpdatedByFirstTransaction");
        patient2.setLastName("UpdatedBySecondTransaction");

        patientRepository.saveAndFlush(patient1);

        assertThrows(OptimisticLockException.class, () -> {
            patientRepository.saveAndFlush(patient2);
        });
    }
    
    @Test
    void testFindVisitsByPatientId() {
        List<VisitEntity> visits = visitService.findVisitsByPatientId(1L);
        assertEquals(2, visits.size());
        assertEquals("Routine check-up", visits.get(0).getDescription());
    }
    
    @Test
    void testFindPatientsWithMoreThanXVisits() {
        List<PatientEntity> patients = patientRepository.findPatientsWithMoreThanXVisits(1L);
        assertEquals(1, patients.size());
        assertEquals("John", patients.get(0).getFirstName());
    }
    
    @Test
    void testFindBySomeNewFieldGreaterThan() {
        List<PatientEntity> patients = patientRepository.findBySomeNewFieldGreaterThan(30);
        assertEquals(1, patients.size());
        assertEquals("Jane", patients.get(0).getFirstName());
    }
    */
}