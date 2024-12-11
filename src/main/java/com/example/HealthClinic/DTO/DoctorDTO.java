package com.example.HealthClinic.DTO;

public record DoctorDTO (
        String firstname,
        String lastname,
        String specialization,
        String clinic,
        String phoneNumber
){
}
