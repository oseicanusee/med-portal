package com.healthportal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.healthportal.dtos.DoctorDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Getter
@Setter
@Table(name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "doctor_id")
    private String doctor_id;

    @Column(name = "email", unique = true)
    private String email;



//    private List<Patient> patientList;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference
    private List<Appointment> appointments;




    public Doctor(DoctorDTO doctorDTO){
        this.firstName = doctorDTO.getFirstName();
        this.lastName = doctorDTO.getLastName();
        this.doctor_id = doctorDTO.getDoctor_id();
//        this.patientList = doctorDTO.getPatientList();
        this.appointments = doctorDTO.getAppointments();
    }


}
