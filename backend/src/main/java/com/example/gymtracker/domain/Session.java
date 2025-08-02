package com.example.gymtracker.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity @Table(name = "sessions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Session {
  @Id private UUID id;
  @Column(name="user_id", nullable=false) private UUID userId;
  @Column(name="workout_id") private UUID workoutId;
  @Column(name="session_date", nullable=false) private LocalDate sessionDate;
  private String notes;
  @PrePersist void pre() { if (id == null) id = UUID.randomUUID(); }
}
