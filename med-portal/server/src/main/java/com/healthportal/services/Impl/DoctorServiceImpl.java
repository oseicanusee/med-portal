package com.healthportal.services.Impl;

import com.healthportal.configuration.MapStructMapper;
import com.healthportal.dtos.DoctorDTO;
import com.healthportal.exceptions.ResourceNotFoundException;
import com.healthportal.exceptions.UserExistsException;
import com.healthportal.models.Doctor;
import com.healthportal.repository.DoctorRepository;
import com.healthportal.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private MapStructMapper mapStructMapper;

    @Override
    public List<DoctorDTO> getAllDoctors() {
        //gets all the doctors from the database and maps them to DTOs.
        return doctorRepository.findAll().stream().map(doctor ->
                mapStructMapper.doctorEntityToDoctorDTO(doctor))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO findDoctorById(long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);


        if(doctorOptional.isPresent()){
            Doctor doctor = doctorOptional.get();
            return mapStructMapper.doctorEntityToDoctorDTO(doctor);

            //find the doctor or else throw an exception that resource not found.
        } else throw new ResourceNotFoundException("Doctor", "id", id);
    }

    @Override
    public DoctorDTO deleteDoctorById(long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);


        if(doctorOptional.isPresent()){
            Doctor doctor = doctorOptional.get();
            doctorRepository.deleteById(id);
            return mapStructMapper.doctorEntityToDoctorDTO(doctor);

            //find the doctor or else throw an exception that resource not found.
        } else throw new ResourceNotFoundException("Doctor", "id", id);
    }

    @Override
    public DoctorDTO saveDoctor(DoctorDTO doctorDTO) throws UserExistsException {
        Optional<Doctor> doctorOptional =  doctorRepository.findByEmail(doctorDTO.getEmail());

        if(doctorOptional.isPresent()){
            throw new UserExistsException(doctorDTO.getEmail() + " exists. Please use a new email");

        } else {
            Doctor doctor = mapStructMapper.DoctorDTOToToDoctorEntity(doctorDTO);
            doctorRepository.save(doctor);
            DoctorDTO savedDoctor = mapStructMapper.doctorEntityToDoctorDTO(doctor);
            return savedDoctor;
        }
    }

    @Override
    @Transactional
    public DoctorDTO updateDoctorInfo(DoctorDTO doctorDTO) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorDTO.getId());
        if(doctorOptional.isPresent()){
            Doctor doctor = doctorOptional.get();
            doctor.setDoctor_id(doctorDTO.getDoctor_id());
            doctor.setAppointments(doctorDTO.getAppointments());
            doctor.setFirstName(doctorDTO.getFirstName());
            doctor.setLastName(doctorDTO.getLastName());
            doctor.setEmail(doctorDTO.getEmail());
            doctorRepository.save(doctor);
            return mapStructMapper.doctorEntityToDoctorDTO(doctor);
        } else {
            throw new ResourceNotFoundException("Doctor", "id", doctorDTO.getId());
        }
    }


}
