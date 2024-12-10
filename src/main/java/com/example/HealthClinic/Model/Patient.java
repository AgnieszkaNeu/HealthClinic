package com.example.HealthClinic.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Patient extends User {

    @ManyToOne
    private Doctor doctor;

    public Patient() {
    }

    public Patient(String username, String firstname, String lastname, String phoneNumber, String password, String PESEL, Doctor doctor){
        super(username, firstname,lastname,phoneNumber,password,PESEL);
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
