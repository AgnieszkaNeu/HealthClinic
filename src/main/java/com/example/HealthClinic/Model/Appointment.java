package com.example.HealthClinic.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue
    Long id;

    @OneToOne
    Patient patient;

    @OneToOne
    Doctor doctor;

    LocalDateTime date;

    public Appointment() {
    }

    public Appointment(Long id, Patient patient, Doctor doctor, LocalDateTime date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
