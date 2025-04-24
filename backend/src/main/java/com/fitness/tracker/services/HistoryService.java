package com.fitness.tracker.services;

import com.fitness.tracker.models.Exercise;
import com.fitness.tracker.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<Exercise> getHistoryByUserId(Long userId) {
        return exerciseRepository.findByUserId(userId);
    }
}