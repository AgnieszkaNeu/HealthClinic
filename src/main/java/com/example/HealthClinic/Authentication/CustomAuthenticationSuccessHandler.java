package com.example.HealthClinic.Authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        var authorities = authentication.getAuthorities();
        String redirectUrl = "/";

        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("DOCTOR"))) {
            redirectUrl = "/doctor/dashboard";
        } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("PATIENT"))) {
            redirectUrl = "/patient/dashboard";
        }
        response.sendRedirect(redirectUrl);
    }
}
