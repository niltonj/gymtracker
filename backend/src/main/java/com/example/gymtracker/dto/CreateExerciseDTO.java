package com.example.gymtracker.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateExerciseDTO(@NotBlank String name, @NotBlank String muscleGroup) {}
