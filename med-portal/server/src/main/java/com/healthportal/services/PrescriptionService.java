package com.healthportal.services;

import com.healthportal.dtos.PrescriptionDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PrescriptionService {
    List<PrescriptionDTO> getAllPrescriptionsByPatientId(Long patientId);

    List<PrescriptionDTO> getAllPrescriptionsByDoctorId(Long doctorId);

    @Transactional
    void addPrescription(PrescriptionDTO prescriptionDto, Long patientId);

    Optional<PrescriptionDTO> getPrescriptionById(Long prescriptionId);

    @Transactional
    void deletePrescriptionById(Long prescriptionId);

    @Transactional
    void changeStatusPrescriptionById(Long prescriptionId);

    @Transactional
    void updatePrescriptionById(PrescriptionDTO prescriptionDto);
}
