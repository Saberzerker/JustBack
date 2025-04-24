package com.fitness.tracker.dto;

public class UserDTO {
    private final Long id;
    private final String username;
    private final String email;
    private final int age;
    private final double weight;
    private final double height;

    // Constructor
    public UserDTO(Long id, String username, String email, int age, double weight, double height) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}