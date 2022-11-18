package com.healthportal.repository;

import com.healthportal.models.Appointment;
import com.healthportal.models.Doctor;
import com.healthportal.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByDoctorEquals(Doctor doctor);
    List<Appointment> findAllByPatientEquals(Patient patient);
}
