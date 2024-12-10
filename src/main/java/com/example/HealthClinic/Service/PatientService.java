package com.example.HealthClinic.Service;

import com.example.HealthClinic.Mapper.myMapper;
import com.example.HealthClinic.Model.Doctor;
import com.example.HealthClinic.Model.Patient;
import com.example.HealthClinic.DTO.PatientDTO;
import com.example.HealthClinic.Repository.DoctorRepo;
import com.example.HealthClinic.Repository.PatientRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService extends GenericService <Patient, PatientDTO>{

    private final PasswordEncoder passwordEncoder;

    private final DoctorRepo doctorRepo;

    private final PatientRepo patientRepo;

    public PatientService(JpaRepository<Patient, Long> repository, myMapper<Patient, PatientDTO> mapper, PasswordEncoder passwordEncoder, DoctorRepo doctorRepo, PatientRepo patientRepo) {
        super(repository, mapper);
        this.patientRepo = patientRepo;
        this.passwordEncoder = passwordEncoder;
        this.doctorRepo = doctorRepo;
    }

    public void save(Patient patient){
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        patientRepo.save(patient);
    }

    @Override
    public void update(Long id, PatientDTO DTO) {
        Optional<Patient> optionalPatient = patientRepo.findById(id);

        if(optionalPatient.isEmpty()){
            System.out.println("Patient with id " + id + " not found, skipping update.");
            return;
        }

        Patient existingPatient = optionalPatient.get();

        if (DTO.firstname() != null){
            existingPatient.setFirstname(DTO.firstname());
        }

        if (DTO.lastname() != null){
            existingPatient.setLastname(DTO.lastname());
        }

        if(DTO.doctorId() != null){
            Doctor doctor = doctorRepo.findById(DTO.doctorId()).orElse(new Doctor());
            existingPatient.setDoctor(doctor);
        }

        patientRepo.save(existingPatient);
    }
}
