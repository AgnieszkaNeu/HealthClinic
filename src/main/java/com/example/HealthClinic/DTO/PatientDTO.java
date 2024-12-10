package com.example.HealthClinic.DTO;

public record PatientDTO(
        String firstname,
        String lastname,
        String phoneNumber,
        Long doctorId
) {
}
