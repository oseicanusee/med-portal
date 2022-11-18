package com.healthportal.services;

import com.healthportal.dtos.PatientDTO;
import com.healthportal.models.Patient;

import javax.transaction.Transactional;
import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    @Transactional
    Patient savePatient(PatientDTO patientDto);
}
