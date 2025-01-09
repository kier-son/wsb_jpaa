import com.jpacourse.persistence.entity.PatientEntity;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

@Test
void testFindPatientsWithMoreThanXVisits() {
    List<PatientEntity> patients = patientRepository.findPatientsWithMoreThanXVisits(1L);
    assertEquals(1, patients.size());
    assertEquals("John", patients.get(0).getFirstName());
}
