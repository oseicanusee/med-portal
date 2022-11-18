package com.healthportal.services;

import com.healthportal.dtos.AppointmentDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<AppointmentDTO> getAllAppointmentsByPatientId(Long patientId);

    List<AppointmentDTO> getAllAppointmentsByDoctorId(Long doctorId);

    @Transactional
    void addAppointment(AppointmentDTO appointmentDto, Long patientId);

    Optional<AppointmentDTO> getAppointmentById(Long appointmentId);

    @Transactional
    void deleteAppointmentById(Long appointmentId);

    @Transactional
    void changeStatusAppointmentById(Long appointmentId);

    @Transactional
    void updateAppointmentById(AppointmentDTO appointmentDto);
}
