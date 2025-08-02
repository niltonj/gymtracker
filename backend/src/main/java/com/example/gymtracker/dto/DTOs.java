package com.example.gymtracker.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.UUID;

public record ExerciseDTO(UUID id, String name, String muscleGroup) {}
public record CreateExerciseDTO(@NotBlank String name, @NotBlank String muscleGroup) {}

public record CreateSessionDTO(@NotNull LocalDate sessionDate,
                               UUID workoutId,
                               String notes) {}

public record CreateSetDTO(@NotNull UUID exerciseId,
                           @Min(1) int setIndex,
                           @Min(1) int reps,
                           @DecimalMin("0.0") double weightKg,
                           Double rpe,
                           Boolean isPr) {}
