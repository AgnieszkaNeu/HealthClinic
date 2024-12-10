package com.example.HealthClinic.Repository;

import com.example.HealthClinic.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Optional<Patient> findByUsername(String username);
}
