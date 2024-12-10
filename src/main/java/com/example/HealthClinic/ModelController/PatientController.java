package com.example.HealthClinic.ModelController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    @GetMapping("/patient/dashboard")
    public String dashboard(Model model){
        model.addAttribute("content", "patientIndex");
        return "layout";
    }

    @GetMapping("/patient/appointments")
    public String showPlannedAppointments(Model model){
        model.addAttribute("content", "inProgress");
        return "layout";
    }

    @GetMapping("/patient/makeAnAppointment")
    public String makeAnAppointment(Model model){
        model.addAttribute("content", "inProgress");
        return "layout";
    }

}
