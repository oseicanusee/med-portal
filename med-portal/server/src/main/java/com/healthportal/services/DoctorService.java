package com.healthportal.services;

import com.healthportal.dtos.DoctorDTO;
import com.healthportal.exceptions.UserExistsException;

import java.util.List;

public interface DoctorService {
    List<DoctorDTO> getAllDoctors();
    DoctorDTO findDoctorById(long id);
    DoctorDTO deleteDoctorById(long id);
    DoctorDTO saveDoctor(DoctorDTO doctorDTO) throws UserExistsException;
    DoctorDTO updateDoctorInfo(DoctorDTO doctorDTO);
}
