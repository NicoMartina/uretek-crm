package com.uretek_crm.uretek_crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. Password encoder Bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Use BCrypt for secure password hashing
        return new BCryptPasswordEncoder();
    }

    // 2. In-Memory User Store (Temporary for MVP)
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        // Creates a default user "user" with password "password" and role "USER"
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("adminpass")) // Encode the password!
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }


    // 3. Security Filter Chain Configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configure authorization rules
        http
                // Configure authorization rules
                .authorizeHttpRequests((requests) -> requests
                        // Ensure all API endpoints require authentication
                        .requestMatchers("/api/v1/**").authenticated()
                        // Any other requests also require authentication
                        .anyRequest().authenticated()
                )
                // Configure the login behavior
                .formLogin(form -> form
                        .permitAll() // Allow everyone to see the login page
                )
                // Configure logout
                .logout((logout) -> logout.permitAll())
                // Temporarily disable CSRF for Postman/API testing ease
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

}
