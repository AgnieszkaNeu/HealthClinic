package com.example.HealthClinic.Authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserService customUserService;

    private final CustomAuthenticationSuccessHandler successHandler;

    public SecurityConfig(CustomUserService customUserService, CustomAuthenticationSuccessHandler successHandler) {
        this.customUserService = customUserService;
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (authz) -> authz
                        .requestMatchers("/register", "/register/**").permitAll()
                        .requestMatchers("/doctor/**").hasAuthority("DOCTOR")
                        .requestMatchers("/patient/**").hasAuthority("PATIENT")
                        .anyRequest().authenticated()
                )
                .formLogin(form ->
                                    form.loginPage("/login")
                                            .successHandler(successHandler)
                                            .permitAll())
                .logout(LogoutConfigurer::permitAll)
        ;

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserService).passwordEncoder(passwordEncoder());

        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

