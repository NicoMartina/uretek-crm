package com.uretek_crm.uretek_crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

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


    // 3. Security Filter Chain Configuration (THE FIX IS HERE)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF (needed for Postman POST/PUT/DELETE)
                .csrf(AbstractHttpConfigurer::disable)

                // 2. Set Session Policy to Stateless (CRITICAL)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // 3. Configure Authorization Rules (CRITICAL)
                .authorizeHttpRequests((requests) -> requests
                        // Require authentication for ALL API endpoints
                        .requestMatchers("/api/v1/**").authenticated()
                        // Deny access to everything else unless specified
                        .anyRequest().denyAll()
                )

                // 4. Use HTTP Basic Authentication (forces 401 response)
                .httpBasic(Customizer.withDefaults()); // Use default HTTP Basic Auth (username/password in request header)

        // IMPORTANT: .formLogin() and .logout() are REMOVED entirely.

        return http.build();
    }

}
