package com.fitness.tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configure CORS
        http.cors(cors -> cors.configurationSource(request -> {
            var corsConfig = new org.springframework.web.cors.CorsConfiguration();
            corsConfig.addAllowedOrigin("http://localhost:8000");
            corsConfig.addAllowedMethod("*");
            corsConfig.addAllowedHeader("*");
            corsConfig.setAllowCredentials(true);
            return corsConfig;
        }));

        // Configure CSRF
        http.csrf(csrf -> csrf.disable());

        // Configure Authorization
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
        );

        return http.build();
    }
}