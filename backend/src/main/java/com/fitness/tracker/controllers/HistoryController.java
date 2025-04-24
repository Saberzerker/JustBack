package com.fitness.tracker.controllers;

import com.fitness.tracker.models.Exercise;
import com.fitness.tracker.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Exercise>> getUserHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(historyService.getHistoryByUserId(userId));
    }
}