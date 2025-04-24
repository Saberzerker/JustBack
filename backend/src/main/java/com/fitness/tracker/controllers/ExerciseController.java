package com.fitness.tracker.controllers;

import com.fitness.tracker.models.Exercise;
import com.fitness.tracker.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<Exercise> logExercise(@RequestBody Exercise exercise) {
        return ResponseEntity.ok(exerciseService.logExercise(exercise));
    }

    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return ResponseEntity.ok(exerciseService.getAllExercises());
    }
}