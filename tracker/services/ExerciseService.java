package com.fitness.tracker.services;

import com.fitness.tracker.models.Exercise;
import com.fitness.tracker.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    /**
     * Logs a new exercise by saving it in the database.
     * @param exercise The exercise to log.
     * @return The saved exercise.
     */
    public Exercise logExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    /**
     * Retrieves all exercises from the database.
     * @return A list of all exercises.
     */
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }
}