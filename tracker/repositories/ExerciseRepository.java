package com.fitness.tracker.repositories;

import com.fitness.tracker.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByUserId(Long userId);
}