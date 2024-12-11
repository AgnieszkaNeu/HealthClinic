package com.example.HealthClinic.ModelController;

import com.example.HealthClinic.Authentication.CustomUserService;
import com.example.HealthClinic.Model.Doctor;
import com.example.HealthClinic.Model.Patient;
import com.example.HealthClinic.Model.User;
import com.example.HealthClinic.Service.DoctorService;
import com.example.HealthClinic.Service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

    private final DoctorService doctorService;

    private final PatientService patientService;

     AuthenticationController(DoctorService doctorService, PatientService patientService, CustomUserService userService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("content", "login");
        return "layout";
    }

    @GetMapping("/register")
    public String showForm(Model model){
        model.addAttribute("UserForm", new User());
        model.addAttribute("content", "register");

        return "layout";
    }

    @PostMapping ("/register")
    public String createUserAccount(
            @ModelAttribute("UserForm") User user,
            @RequestParam("role") String role
    ){
        if(role.equals("doctor")){
            Doctor doctor = new Doctor(user.getUsername(),user.getFirstname(),user.getLastname(),
                    user.getPhoneNumber(),user.getPassword(),user.getPESEL(),null,null,null);
            doctorService.save(doctor);
        }
        if(role.equals("patient")){
            Patient patient = new Patient(user.getUsername(),user.getFirstname(),user.getLastname(),
                    user.getPhoneNumber(),user.getPassword(),user.getPESEL(),null);
            patientService.save(patient);
        }
        return "redirect:/login";
    }
}
