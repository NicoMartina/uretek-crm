package com.uretek_crm.uretek_crm.config;

// Removed the unused DaoAuthenticationProvider import and AuthenticationManager imports

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. Password Encoder Bean (Keep this one!)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // 2. Security Filter Chain Configuration (FINAL CORRECTED VERSION)
    @Bean
    public SecurityFilterChain securityFilterChain(
            // Spring will auto-inject your CustomUserDetailsService and PasswordEncoder
            HttpSecurity http,
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) throws Exception {

        http
                // CRITICAL STEP: Tells Spring to use your CustomUserDetailsService
                // and PasswordEncoder for authentication (database access).
                .userDetailsService(userDetailsService)

                // 1. Disable CSRF (needed for Postman POST/PUT/DELETE)
                .csrf(AbstractHttpConfigurer::disable)

                // 2. Set Session Policy to Stateless (CRITICAL for REST API)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // 3. Configure Authorization Rules
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/v1/**").authenticated()
                        .anyRequest().denyAll()
                )

                // 4. Use HTTP Basic Authentication
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}