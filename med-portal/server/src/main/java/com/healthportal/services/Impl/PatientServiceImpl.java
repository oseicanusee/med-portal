package com.healthportal.services.Impl;

import com.healthportal.dtos.PatientDTO;
import com.healthportal.models.Patient;
import com.healthportal.repository.PatientRepository;
import com.healthportal.services.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @Transactional
    public Patient savePatient(PatientDTO patientDTO) {
        return patientRepository.save(new Patient(patientDTO));
    }
}