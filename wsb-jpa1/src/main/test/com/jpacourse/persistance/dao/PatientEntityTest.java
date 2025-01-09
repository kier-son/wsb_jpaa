import com.jpacourse.persistance.dao.Rollback;
import com.jpacourse.persistence.entity.PatientEntity;
import org.testng.annotations.Test;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;

import static org.testng.Assert.assertThrows;
@Test
@Transactional
@Rollback
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
