package com.example.gymtracker.repository;

import com.example.gymtracker.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {}
