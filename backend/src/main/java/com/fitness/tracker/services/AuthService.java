package com.fitness.tracker.services;

import com.fitness.tracker.models.User;
import com.fitness.tracker.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    
    @Autowired
    private UserRepository userRepository;

    public User authenticate(String username, String password) {
        logger.debug("Login attempt - Username: {}", username);
        
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new BadCredentialsException("Invalid username or password"));
        
        // Simple plain text password comparison
        if (!password.equals(user.getPassword())) {
            logger.debug("Password mismatch for user: {}", username);
            throw new BadCredentialsException("Invalid username or password");
        }
        
        logger.debug("Login successful for user: {}", username);
        return user;
    }

    public User register(User user) {
        // Check if username already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        
        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        
        // Store password as plain text
        return userRepository.save(user);
    }
}