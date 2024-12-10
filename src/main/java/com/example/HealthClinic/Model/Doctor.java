package com.example.HealthClinic.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Doctor extends User {

    private String specialization;

    private String licence;

    public Doctor() {
    }

    public Doctor(String username, String firstname, String lastname, String phoneNumber,
                  String password, String PESEL, String specialization, String licence){
        super(username, firstname,lastname,phoneNumber,password,PESEL);
        this.specialization = specialization;
        this.licence = licence;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }
}
