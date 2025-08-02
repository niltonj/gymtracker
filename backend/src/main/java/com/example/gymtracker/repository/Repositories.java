package com.example.gymtracker.repository;

import com.example.gymtracker.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {}
public interface SessionRepository extends JpaRepository<Session, UUID> {}
public interface SetEntryRepository extends JpaRepository<SetEntry, UUID> {
  List<SetEntry> findBySessionIdOrderBySetIndexAsc(UUID sessionId);
}
