package com.fitness.tracker.controllers;

import com.fitness.tracker.dto.AuthResponse;
import com.fitness.tracker.dto.LoginRequest;
import com.fitness.tracker.dto.UserDTO;
import com.fitness.tracker.models.User;
import com.fitness.tracker.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            User user = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
            UserDTO userDTO = new UserDTO(
                user.getId(), 
                user.getUsername(), 
                user.getEmail(), 
                user.getAge(), 
                user.getWeight(), 
                user.getHeight()
            );
            return ResponseEntity.ok(new AuthResponse(userDTO));
        } catch (Exception e) {
            logger.error("Login failed for user: " + loginRequest.getUsername(), e);
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User registeredUser = authService.register(user);
            UserDTO userDTO = new UserDTO(
                registeredUser.getId(), 
                registeredUser.getUsername(), 
                registeredUser.getEmail(), 
                registeredUser.getAge(), 
                registeredUser.getWeight(), 
                registeredUser.getHeight()
            );
            return ResponseEntity.ok(new AuthResponse(userDTO));
        } catch (Exception e) {
            logger.error("Registration failed for user: " + user.getUsername(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}