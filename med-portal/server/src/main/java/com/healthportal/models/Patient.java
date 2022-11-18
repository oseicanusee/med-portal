package com.healthportal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.healthportal.dtos.PatientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Data
@Table(name = "Patients")
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    // fields go here

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column
    private String birthDate;

    @Column
    private String address;

    @Column
    private String gender;

    @Column
    private String phone;

    @Column
    private String password;

//    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Doctor assignedDoctor;


//    private List<Prescription> medicines;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference
    private List<Appointment> appointmentSet = new ArrayList<>();

    public Patient(PatientDTO patientDto) {
        this.firstName = patientDto.getFirstName();
        this.lastName = patientDto.getLastName();
        this.email = patientDto.getEmail();
        this.birthDate = patientDto.getBirthDate();
        this.address = patientDto.getAddress();
        this.gender = patientDto.getAddress();
        this.phone = patientDto.getPhone();
        this.password = patientDto.getPassword();
    }
}
