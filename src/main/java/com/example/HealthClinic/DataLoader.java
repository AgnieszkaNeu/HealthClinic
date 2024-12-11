package com.example.HealthClinic;

import com.example.HealthClinic.Model.Patient;
import com.example.HealthClinic.Service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PatientService patientService;

    public DataLoader(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient("user", "Firstname", "Lastname", "+48 123 123 123", "pass","123",null);
        patientService.save(patient);
    }
}
