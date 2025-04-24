package com.fitness.tracker.controllers;

import com.fitness.tracker.calculator.CalorieCalculatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CalorieController {

    private final Map<String, CalorieCalculatorStrategy> strategyMap;

    @Autowired
    public CalorieController(List<CalorieCalculatorStrategy> strategies) {
        strategyMap = strategies.stream()
            .collect(Collectors.toMap(strategy -> strategy.getClass().getSimpleName(), Function.identity()));
    }

    @PostMapping("/calculate-calories")
    public ResponseEntity<?> calculateCalories(@RequestBody CalorieInput input) {
        CalorieCalculatorStrategy strategy = strategyMap.get(input.getActivityType());
        if (strategy == null) {
            return ResponseEntity.badRequest().body("Invalid activity type.");
        }
        double caloriesBurned = strategy.calculateCalories(input.getWeight(), input.getDuration());
        return ResponseEntity.ok(new CalorieOutput(caloriesBurned));
    }

    public static class CalorieInput {
        private String activityType;
        private double weight;
        private int duration;

        // Getters and Setters
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