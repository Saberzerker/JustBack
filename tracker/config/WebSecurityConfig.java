// package com.fitness.tracker.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class WebSecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         // Configure CORS
//         http.cors(cors -> cors.configurationSource(request -> {
//             var corsConfig = new org.springframework.web.cors.CorsConfiguration();
//             corsConfig.addAllowedOrigin("http://localhost:8000"); // Frontend URL
//             corsConfig.addAllowedMethod("*"); // Allow all HTTP methods
//             corsConfig.addAllowedHeader("*"); // Allow all headers
//             corsConfig.setAllowCredentials(true); // Allow credentials (e.g., cookies, authorization headers)
//             return corsConfig;
//         }));

//         // Disable CSRF for simplicity (consider enabling it in production with proper configuration)
//         http.csrf(csrf -> csrf.disable());

//         // Configure Authorization
//         http.authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/api/**").permitAll() // Allow unrestricted access to all API endpoints
//                 .anyRequest().authenticated() // All other requests require authentication
//         );

//         return http.build();
//     }
// }   