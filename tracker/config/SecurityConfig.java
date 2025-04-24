// package com.fitness.tracker.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.context.annotation.Bean;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(csrf -> csrf.disable()) // disable CSRF for simplicity (or configure it properly for production)
//             .authorizeHttpRequests(auth -> auth
//                 .anyRequest().permitAll() // allow all requests
//             )
//             .formLogin().disable()       // disable Spring login forms
//             .httpBasic().disable();      // disable Basic Auth

//         return http.build();
//     }
// }
