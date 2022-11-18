package com.healthportal.controllers;

import com.healthportal.dtos.PrescriptionDTO;
import com.healthportal.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/doctor/{doctorId}")
    public List<PrescriptionDTO> getPrescriptionByDoctor(@PathVariable Long doctorId){
        return prescriptionService.getAllPrescriptionsByDoctorId(doctorId);
    }

    @GetMapping("/patient/{patientId}")
    public List<PrescriptionDTO> getPrescriptionByPatient(@PathVariable Long patientId){
        return prescriptionService.getAllPrescriptionsByPatientId(patientId);
    }

    @GetMapping("/{prescriptionId}")
    public Optional<PrescriptionDTO> getPrescriptionById(@PathVariable Long prescriptionId){
        return prescriptionService.getPrescriptionById(prescriptionId);
    }

    @PostMapping("/patient/{patientId}")
    public void addPrescription(@RequestBody PrescriptionDTO prescriptionDto,@PathVariable Long patientId) {
        prescriptionService.addPrescription(prescriptionDto, patientId);
    }

    @DeleteMapping("/{prescriptionId}")
    public void deletePrescriptionById(@PathVariable Long prescriptionId){
        prescriptionService.deletePrescriptionById(prescriptionId);
    }

    @PutMapping("/{prescriptionId}")
    public void changeStatusPrescriptionById(@PathVariable Long prescriptionId){
        prescriptionService.changeStatusPrescriptionById(prescriptionId);
    }

    @PutMapping
    public void updatePrescription(@RequestBody PrescriptionDTO prescriptionDto){
        prescriptionService.updatePrescriptionById(prescriptionDto);
    }
}
