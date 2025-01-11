package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootApplication(scanBasePackages = "com.jpacourse")
@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest 
{
    //@Autowired
    //private PatientService patientService;
    
    @Test
    public void TestHealthScore()
    {
        
    }
    
    /*@Autowired
    private PatientService patientService;

    //@Autowired
    //private DoctorService doctorService;

    @Test
    public void testDeletePatientCascade() {
        // Pobierz pacjenta
        PatientEntity patient = patientDao.findOne(1L);
        int initialVisitsCount = patient.getVisits().size();
        Long doctorId = patient.getVisits().get(0).getDoctor().getId();

        // Usuń pacjenta
        patientService.deletePatientById(patient.getId());

        // Sprawdź, czy pacjent został usunięty
        PatientEntity deletedPatient = patientDao.findOne(1L);
        assertThat(deletedPatient).isNull();

        // Sprawdź, czy lekarz nie został usunięty
        DoctorEntity doctor = doctorDao.findOne(doctorId);
        assertThat(doctor).isNotNull();
    }

    @Test
    public void testFindPatientById() {
        // Dodaj healthScore do pacjenta w data.sql
        PatientTO patient = patientService.findPatientById(1L);

        assertThat(patient).isNotNull();
        assertThat(patient.getHealthScore()).isNotNull(); // Sprawdź dodatkowe pole
        assertThat(patient.getVisits()).isNotEmpty();

        VisitTO firstVisit = patient.getVisits().get(0);
        assertThat(firstVisit.getDoctorFirstName()).isNotNull();
        assertThat(firstVisit.getDoctorLastName()).isNotNull();
        assertThat(firstVisit.getTreatmentTypes()).isNotEmpty();
    }*/
}