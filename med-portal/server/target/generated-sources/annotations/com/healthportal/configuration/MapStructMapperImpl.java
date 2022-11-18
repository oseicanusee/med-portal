package com.healthportal.configuration;

import com.healthportal.dtos.DoctorDTO;
import com.healthportal.models.Appointment;
import com.healthportal.models.Doctor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-17T11:50:20-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public DoctorDTO doctorEntityToDoctorDTO(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO.setId( doctor.getId() );
        doctorDTO.setFirstName( doctor.getFirstName() );
        doctorDTO.setLastName( doctor.getLastName() );
        doctorDTO.setDoctor_id( doctor.getDoctor_id() );
        doctorDTO.setEmail( doctor.getEmail() );
        List<Appointment> list = doctor.getAppointments();
        if ( list != null ) {
            doctorDTO.setAppointments( new ArrayList<Appointment>( list ) );
        }

        return doctorDTO;
    }

    @Override
    public Doctor DoctorDTOToToDoctorEntity(DoctorDTO doctorDTO) {
        if ( doctorDTO == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( doctorDTO.getId() );
        doctor.setFirstName( doctorDTO.getFirstName() );
        doctor.setLastName( doctorDTO.getLastName() );
        doctor.setDoctor_id( doctorDTO.getDoctor_id() );
        doctor.setEmail( doctorDTO.getEmail() );
        List<Appointment> list = doctorDTO.getAppointments();
        if ( list != null ) {
            doctor.setAppointments( new ArrayList<Appointment>( list ) );
        }

        return doctor;
    }
}
