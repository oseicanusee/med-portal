package com.healthportal.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.healthportal.models.Doctor;
import com.healthportal.models.Patient;
import com.healthportal.models.Prescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PrescriptionDTO {

    private Long id;
    private Doctor doctor;
    private Patient patient;
    private String pharmacyName;
    private String drugName;
    private java.sql.Date rStartDate;
    private java.sql.Date rRefillDate;
    private Integer numberRefills;
    private String status;

    public PrescriptionDTO(Prescription prescription) {
        if (prescription.getId() != null) {
            this.id = prescription.getId();
        }
        if (prescription.getDoctor() != null) {
            this.doctor = prescription.getDoctor();
        }
        if (prescription.getPatient() != null) {
            this.patient = prescription.getPatient();
        }
        if (prescription.getPharmacyName() != null) {
            this.pharmacyName = prescription.getPharmacyName();
        }
        if (prescription.getDrugName() != null) {
            this.drugName = prescription.getDrugName();
        }
        if (prescription.getRStartDate() != null) {
            this.rStartDate = prescription.getRStartDate();
        }
        if (prescription.getRRefillDate() != null) {
            this.rRefillDate = prescription.getRRefillDate();
        }
        if (prescription.getNumberRefills() != null) {
            this.numberRefills = prescription.getNumberRefills();
        }
        if (prescription.getStatus() != null) {
            this.status = prescription.getStatus();
        }
    }
}
