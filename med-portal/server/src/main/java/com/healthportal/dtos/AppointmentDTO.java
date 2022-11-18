package com.healthportal.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.healthportal.models.Appointment;
import com.healthportal.models.Doctor;
import com.healthportal.models.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentDTO {

    private Long id;
    private Doctor doctor;
    private Patient patient;
    private String department;
    private java.sql.Date rDate;
    private java.sql.Time rTime;
    private String appcategory;
    private String status;

    public AppointmentDTO(Appointment appointment) {
        if (appointment.getId() != null) {
            this.id = appointment.getId();
        }
        if (appointment.getDoctor() != null) {
            this.doctor = appointment.getDoctor();
        }
        if (appointment.getPatient() != null) {
            this.patient = appointment.getPatient();
        }
        if (appointment.getDepartment() != null) {
            this.department = appointment.getDepartment();
        }
        if (appointment.getRDate() != null) {
            this.rDate = appointment.getRDate();
        }
        if (appointment.getRTime() != null) {
            this.rTime = appointment.getRTime();
        }
        if (appointment.getAppcategory() != null) {
            this.appcategory = appointment.getAppcategory();
        }
        if (appointment.getStatus() != null) {
            this.status = appointment.getStatus();
        }
    }
}
