package com.fitness.tracker.calculator;

public class CyclingCalorieCalculator implements CalorieCalculatorStrategy {
    private static final double MET = 7.5;

    @Override
    public double calculateCalories(double weight, int duration) {
        return (MET * weight * duration) / 200;
    }
}