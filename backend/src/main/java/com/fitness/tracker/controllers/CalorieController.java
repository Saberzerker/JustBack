package com.fitness.tracker.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalorieController {

    @PostMapping("/calculate-calories")
    public ResponseEntity<?> calculateCalories(@RequestBody CalorieInput input) {
        try {
            double MET;
            switch (input.getActivityType().toLowerCase()) {
                case "running":
                    MET = 9.8;
                    break;
                case "cycling":
                    MET = 7.5;
                    break;
                case "walking":
                    MET = 3.8;
                    break;
                default:
                    return ResponseEntity.badRequest().body("Invalid activity type.");
            }

            double caloriesBurned = (MET * input.getWeight() * input.getDuration()) / 200;
            return ResponseEntity.ok(new CalorieOutput(caloriesBurned));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error calculating calories: " + e.getMessage());
        }
    }

    public static class CalorieInput {
        private String activityType;
        private double weight;
        private int duration;

        public String getActivityType() {
            return activityType;
        }

        public void setActivityType(String activityType) {
            this.activityType = activityType;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }
    }

    public static class CalorieOutput {
        private final double caloriesBurned;

        public CalorieOutput(double caloriesBurned) {
            this.caloriesBurned = caloriesBurned;
        }

        public double getCaloriesBurned() {
            return caloriesBurned;
        }
    }
}