package com.example.gymtracker.dto;

import jakarta.validation.constraints.*;
import java.util.UUID;

public record CreateSetDTO(@NotNull UUID exerciseId,
                           @Min(1) int setIndex,
                           @Min(1) int reps,
                           @DecimalMin("0.0") double weightKg,
                           Double rpe,
                           Boolean isPr) {}
