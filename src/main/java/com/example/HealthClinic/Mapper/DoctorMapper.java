package com.example.HealthClinic.Mapper;

import com.example.HealthClinic.DTO.DoctorDTO;
import com.example.HealthClinic.Model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper extends myMapper<Doctor, DoctorDTO> {
    @Override
    Doctor toEntity(DoctorDTO DTO);

    @Override
    DoctorDTO toDTO(Doctor doctor);
}
