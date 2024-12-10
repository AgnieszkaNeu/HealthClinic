package com.example.HealthClinic.Mapper;

import com.example.HealthClinic.DTO.PatientDTO;
import com.example.HealthClinic.Model.Doctor;
import com.example.HealthClinic.Model.Patient;
import com.example.HealthClinic.Repository.DoctorRepo;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PatientMapper implements myMapper<Patient, PatientDTO> {

    DoctorRepo doctorRepo;

    public PatientMapper(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Patient toEntity(PatientDTO DTO){
        if (DTO == null) {
            return null;
        } else {
            Patient patient = new Patient();
            patient.setFirstname(DTO.firstname());
            patient.setLastname(DTO.lastname());
            patient.setPhoneNumber(DTO.phoneNumber());

            Optional <Doctor> doctor = doctorRepo.findById(DTO.doctorId());
            doctor.ifPresent(patient::setDoctor);

            return patient;
        }
    }
    @Override
    public PatientDTO toDTO(Patient patient){
        if (patient == null) {
            return null;
        } else {
            String firstname = null;
            String lastname = null;
            String phoneNumber = null;
            Long doctorId = null;

            firstname = patient.getFirstname();
            lastname = patient.getLastname();
            phoneNumber = patient.getPhoneNumber();

            Optional <Doctor> doctor = Optional.ofNullable(patient.getDoctor());

            if(doctor.isPresent()){
                doctorId = doctor.get().getId();
            }

            PatientDTO patientDTO = new PatientDTO(firstname, lastname, phoneNumber, doctorId);
            return patientDTO;
        }
    }

}
