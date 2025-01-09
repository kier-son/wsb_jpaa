import com.jpacourse.persistence.entity.PatientEntity;
import org.testng.annotations.Test;
import com.jpacourse.repository.PatientRepository;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

@Test
void testFindByLastName() {
    List<PatientEntity> patients = patientRepository.findByLastName("Doe");
    assertEquals(1, patients.size());
    assertEquals("Jan", patients.get(0).getFirstName());
}
