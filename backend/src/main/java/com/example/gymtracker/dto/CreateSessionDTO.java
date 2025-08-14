package com.example.gymtracker.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

public record CreateSessionDTO(@NotNull LocalDate sessionDate,
                               UUID workoutId,
                               String notes) {}
