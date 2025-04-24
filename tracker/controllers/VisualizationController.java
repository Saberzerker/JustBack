package com.fitness.tracker.controllers;

import com.fitness.tracker.services.VisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visualizations")
public class VisualizationController {
    @Autowired
    private VisualizationService visualizationService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserActivityVisualization(@PathVariable Long userId) {
        return ResponseEntity.ok(visualizationService.getVisualizationData(userId));
    }
}