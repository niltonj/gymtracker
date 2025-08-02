package com.example.gymtracker.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity @Table(name = "exercises")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Exercise {
  @Id private UUID id;
  @Column(nullable=false, length=128) private String name;
  @Column(name="muscle_group", nullable=false, length=64) private String muscleGroup;
  @Column(name="created_by") private UUID createdBy;
  @PrePersist void pre() { if (id == null) id = UUID.randomUUID(); }
}
