import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PatientDaoTest {
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private DoctorDao doctorDao;

    @Test
    public void testAddVisitToPatient() {
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
}