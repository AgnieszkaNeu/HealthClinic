package com.example.HealthClinic.ModelController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class DoctorController {

    @GetMapping("/doctor/dashboard")
    public String dashboard(Model model){
        model.addAttribute("content", "doctorIndex");
        return "layout";
    }

    @GetMapping("/doctor/appointments")
    public String showPlannedAppointments(Model model){
        model.addAttribute("content", "inProgress");
        return "layout";
    }
}
