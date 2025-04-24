package com.fitness.tracker.services;

import com.fitness.tracker.models.User;
import com.fitness.tracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setAge(updatedUser.getAge());
        existingUser.setWeight(updatedUser.getWeight());
        existingUser.setHeight(updatedUser.getHeight());
        existingUser.setGender(updatedUser.getGender()); // Update gender
        return userRepository.save(existingUser);
    }
}