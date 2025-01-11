package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface PatientService {
    PatientTO findPatientById(Long id);
    void deletePatientById(Long id);
    PatientTO AddPatient(PatientTO patientTO);
    List<VisitTO> GetVisitsForPatient(Long id);
}

