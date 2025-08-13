package com.example.gymtracker.repository;

import com.example.gymtracker.domain.SetEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SetEntryRepository extends JpaRepository<SetEntry, UUID> {
  List<SetEntry> findBySessionIdOrderBySetIndexAsc(UUID sessionId);
}
