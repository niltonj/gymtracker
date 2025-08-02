package com.example.gymtracker.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity @Table(name = "sets")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SetEntry {
  @Id private UUID id;
  @Column(name="session_id", nullable=false) private UUID sessionId;
  @Column(name="exercise_id", nullable=false) private UUID exerciseId;
  @Column(name="set_index", nullable=false) private Integer setIndex;
  @Column(nullable=false) private Integer reps;
  @Column(name="weight_kg", nullable=false) private Double weightKg;
  private Double rpe;
  @Column(name="is_pr") private Boolean isPr;
  @PrePersist void pre() { if (id == null) id = UUID.randomUUID(); }
}
