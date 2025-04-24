package com.fitness.tracker.dto;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private int age;
    private double weight;
    private double height;

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

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}