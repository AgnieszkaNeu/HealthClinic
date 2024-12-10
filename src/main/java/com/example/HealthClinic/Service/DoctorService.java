package com.example.HealthClinic.Service;

import com.example.HealthClinic.DTO.DoctorDTO;
import com.example.HealthClinic.Mapper.myMapper;
import com.example.HealthClinic.Model.Doctor;
import com.example.HealthClinic.Repository.DoctorRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DoctorService extends GenericService<Doctor, DoctorDTO> {

    private final PasswordEncoder passwordEncoder;

    private final DoctorRepo doctorRepo;


    public DoctorService(JpaRepository<Doctor, Long> repository, myMapper<Doctor, DoctorDTO> mapper, PasswordEncoder passwordEncoder, DoctorRepo doctorRepo) {
        super(repository, mapper);
        this.passwordEncoder = passwordEncoder;
        this.doctorRepo = doctorRepo;
    }

    public void save(Doctor doctor){
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctorRepo.save(doctor);
    }

    @Override
    public void update(Long id, DoctorDTO DTO) {
        Optional<Doctor> optionalDoctor = doctorRepo.findById(id);

        if (optionalDoctor.isEmpty()){
            System.out.println("Doctor with id: " + id + " does not exist.");
            return;
        }

        Doctor existingDoctor = optionalDoctor.get();

        if (DTO.firstname() != null){
            existingDoctor.setFirstname(DTO.firstname());
        }

        if (DTO.lastname() != null){
            existingDoctor.setLastname(DTO.lastname());
        }

        if(DTO.specialization() != null){
            existingDoctor.setSpecialization(DTO.specialization());
        }

        doctorRepo.save(existingDoctor);
    }

    public Doctor getLoggedDoctor(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Doctor> doctor = doctorRepo.findByUsername(username);
        return doctor.orElse(null);
    }
}
