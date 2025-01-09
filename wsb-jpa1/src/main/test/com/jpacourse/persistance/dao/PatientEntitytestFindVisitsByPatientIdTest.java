import com.jpacourse.persistence.entity.VisitEntity;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

@Test
void testFindVisitsByPatientId() {
    List<VisitEntity> visits = visitService.findVisitsByPatientId(1L);
    assertEquals(2, visits.size());
    assertEquals("Routine check-up", visits.get(0).getDescription());
}
