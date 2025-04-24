package com.fitness.tracker.services;

import org.springframework.stereotype.Service;

@Service
public class CalorieService {
    public int calculateCalories(String activityType, int duration) {
        switch (activityType.toLowerCase()) {
            case "running":
                return duration * 10;
            case "cycling":
                return duration * 8;
            case "walking":
                return duration * 5;
            default:
                throw new IllegalArgumentException("Unknown activity type");
        }
    }
}