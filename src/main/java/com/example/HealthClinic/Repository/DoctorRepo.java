package com.example.HealthClinic.Repository;

import com.example.HealthClinic.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByUsername(String username);
}
