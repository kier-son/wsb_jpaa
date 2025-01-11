package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    
    private final PatientDao patientDao;

    @Autowired
    private PatientDao patientRepository;
    
    @Qualifier("visitDao")
    @Autowired
    private VisitDao visitRepository;
    
    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO findPatientById(Long id) {
        PatientEntity patient = patientDao.findOne(id);
        return PatientMapper.mapToTO(patient);
    }

    @Override
    public void deletePatientById(Long id) {
        PatientEntity patient = patientDao.findOne(id);
        patientDao.delete(patient);
    }

    @Override
    public PatientTO AddPatient(PatientTO patientTO) 
    {
        PatientEntity patientEntity = PatientMapper.MapToEntity(patientTO);
        patientRepository.save(patientEntity);
        
        return PatientMapper.mapToTO(patientEntity);
    }

    @Override
    public List<VisitTO> GetVisitsForPatient(Long id) 
    {
        List<VisitEntity> visitEntities = visitRepository.FindAllByPatientId(id);
        if (visitEntities.isEmpty())
            return Collections.emptyList();

        List<VisitTO> visitTOs = visitEntities.stream().map(this::ToVisitTO).collect(Collectors.toList());
        Collections.reverse(visitTOs);// Reverse the list in place
        
        return visitTOs;
    }

    private VisitTO ToVisitTO(VisitEntity visitEntity) 
    {
        VisitTO visitTO = new VisitTO();
        visitTO.setTime(visitEntity.getTime());
        
        return visitTO;
    }
}
