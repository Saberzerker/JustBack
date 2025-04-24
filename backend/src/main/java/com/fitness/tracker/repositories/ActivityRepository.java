package com.fitness.tracker.repositories;

import com.fitness.tracker.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}