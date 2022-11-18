package com.healthportal.services.Impl;

import com.healthportal.dtos.AppointmentDTO;
import com.healthportal.dtos.PrescriptionDTO;
import com.healthportal.models.Appointment;
import com.healthportal.models.Doctor;
import com.healthportal.models.Patient;
import com.healthportal.models.Prescription;
import com.healthportal.repository.AppointmentRepository;
import com.healthportal.repository.DoctorRepository;
import com.healthportal.repository.PatientRepository;
import com.healthportal.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PrescriptionServiceImpl implements com.healthportal.services.PrescriptionService{
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public List<PrescriptionDTO> getAllPrescriptionsByPatientId(Long patientId){
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()){
            List<Prescription> prescriptionList = prescriptionRepository.findAllByPatientEquals(patientOptional.get());
            return prescriptionList.stream().map(prescription -> new PrescriptionDTO(prescription)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<PrescriptionDTO> getAllPrescriptionsByDoctorId(Long doctorId){
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        if (doctorOptional.isPresent()){
            List<Prescription> prescriptionList = prescriptionRepository.findAllByDoctorEquals(doctorOptional.get());
            return prescriptionList.stream().map(prescription -> new PrescriptionDTO(prescription)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void addPrescription(PrescriptionDTO prescriptionDto, Long patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        Optional<Doctor> doctorOptional = doctorRepository.findById((long) 1);
        Prescription prescription = new Prescription(prescriptionDto);
        patientOptional.ifPresent(prescription::setPatient);
        doctorOptional.ifPresent(prescription::setDoctor);
        prescriptionRepository.saveAndFlush(prescription);
    }

    @Override
    public Optional<PrescriptionDTO> getPrescriptionById(Long prescriptionId) {
        Optional<Prescription> prescriptionOptional = prescriptionRepository.findById(prescriptionId);
        if (prescriptionOptional.isPresent()){
            return Optional.of(new PrescriptionDTO(prescriptionOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void deletePrescriptionById(Long prescriptionId) {
        Optional<Prescription> prescriptionOptional = prescriptionRepository.findById(prescriptionId);
        prescriptionOptional.ifPresent(appointment -> prescriptionRepository.delete(appointment));
    }

    @Override
    @Transactional
    public void changeStatusPrescriptionById(Long prescriptionId) {
        Optional<Prescription> prescriptionOptional = prescriptionRepository.findById(prescriptionId);
        prescriptionOptional.ifPresent(prescription -> {
            prescription.setStatus("sentToPharmacy");
            prescriptionRepository.saveAndFlush(prescription);
        });
    }

    @Override
    @Transactional
    public void updatePrescriptionById(PrescriptionDTO prescriptionDto) {
        Optional<Prescription> prescriptionOptional = prescriptionRepository.findById(prescriptionDto.getId());
        prescriptionOptional.ifPresent(prescription -> {

            prescription.setPharmacyName(prescriptionDto.getPharmacyName());
            prescription.setDrugName(prescriptionDto.getDrugName());
            prescription.setRStartDate(prescriptionDto.getRStartDate());
            prescription.setRRefillDate(prescriptionDto.getRRefillDate());
            prescription.setNumberRefills(prescriptionDto.getNumberRefills());
            prescriptionRepository.saveAndFlush(prescription);
        });
    }
}
