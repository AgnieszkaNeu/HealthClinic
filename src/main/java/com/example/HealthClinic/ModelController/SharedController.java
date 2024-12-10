package com.example.HealthClinic.ModelController;

import com.example.HealthClinic.DTO.DoctorDTO;
import com.example.HealthClinic.Service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SharedController {

    private final DoctorService doctorService;

    public SharedController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public String findAllDoctors(Model model){
        List<DoctorDTO> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        model.addAttribute("content", "allDoctors");
        return "layout";
    }
}
