package com.healthportal.configuration;

import com.healthportal.dtos.DoctorDTO;
import com.healthportal.models.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;



@Mapper(componentModel = "spring")
@Component
public interface MapStructMapper {

    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    DoctorDTO doctorEntityToDoctorDTO(Doctor doctor);

    Doctor DoctorDTOToToDoctorEntity(DoctorDTO doctorDTO);


}