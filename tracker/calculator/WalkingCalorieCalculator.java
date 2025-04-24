package com.fitness.tracker.calculator;

public class WalkingCalorieCalculator implements CalorieCalculatorStrategy {
    private static final double MET = 3.8;

    @Override
    public double calculateCalories(double weight, int duration) {
        return (MET * weight * duration) / 200;
    }
}