package com.fitness.tracker.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VisualizationService {
    public Map<String, Object> getVisualizationData(Long userId) {
        // Mocked data for visualization
        Map<String, Object> data = new HashMap<>();
        data.put("userId", userId);
        data.put("activities", new String[]{"Running", "Cycling", "Walking"});
        data.put("calories", new int[]{300, 200, 100});
        return data;
    }
}