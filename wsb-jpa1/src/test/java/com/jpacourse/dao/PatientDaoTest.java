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
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

@SpringBootTest
@Transactional
public class PatientDaoTest 
{

    @Autowired
    private PatientDao patientDao;

    @Test
    void shouldReturnMatchingPatients() 
    {
        // Arrange
        PatientEntity patient1 = new PatientEntity();
        patient1.setFirstName("John");
        patient1.setLastName("Smith");
        patientDao.save(patient1);

        PatientEntity patient2 = new PatientEntity();
        patient2.setFirstName("Jane");
        patient2.setLastName("Smith");
        patientDao.save(patient2);

        PatientEntity patient3 = new PatientEntity();
        patient3.setFirstName("Michael");
        patient3.setLastName("Johnson");
        patientDao.save(patient3);

        // Act
        List<PatientEntity> result = patientDao.FindByLastName("Smith");

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());

        List<String> firstNames = result.stream()
                .map(PatientEntity::getFirstName)
                .collect(Collectors.toList());
        assertTrue(firstNames.contains("John"), "Wynik powinien zawierać pacjenta o imieniu 'John'.");
        assertTrue(firstNames.contains("Jane"), "Wynik powinien zawierać pacjenta o imieniu 'Jane'.");
    }
    
}