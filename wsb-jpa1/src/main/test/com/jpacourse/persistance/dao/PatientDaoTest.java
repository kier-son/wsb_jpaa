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
        assertThat(patient.getVisits()).hasSize(initialVisitsCount + 1);
        assertThat(newVisit).isNotNull();
        assertThat(newVisit.getPatient()).isEqualTo(patient);
        assertThat(newVisit.getDoctor()).isEqualTo(doctor);
    }
}