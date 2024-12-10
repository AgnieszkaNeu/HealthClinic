package com.example.HealthClinic.Repository;

import com.example.HealthClinic.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository <Appointment, Long> {
}
