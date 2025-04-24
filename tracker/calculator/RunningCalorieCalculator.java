package com.fitness.tracker.calculator;

public class RunningCalorieCalculator implements CalorieCalculatorStrategy {
    private static final double MET = 9.8;

    @Override
    public double calculateCalories(double weight, int duration) {
        return (MET * weight * duration) / 200;
    }
}