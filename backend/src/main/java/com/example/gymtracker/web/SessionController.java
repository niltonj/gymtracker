package com.example.gymtracker.web;

import com.example.gymtracker.domain.*;
import com.example.gymtracker.dto.CreateSessionDTO;
import com.example.gymtracker.dto.CreateSetDTO;
import com.example.gymtracker.repository.SessionRepository;
import com.example.gymtracker.repository.SetEntryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class SessionController {
  private final SessionRepository sessions;
  private final SetEntryRepository sets;

  @GetMapping("/{id}")
  public ResponseEntity<Map<String,Object>> get(@PathVariable UUID id){
    return sessions.findById(id)
      .map(s -> {
        Map<String,Object> payload = new HashMap<>();
        payload.put("session", s);
        payload.put("sets", sets.findBySessionIdOrderBySetIndexAsc(id));
        return ResponseEntity.ok(payload);
      }).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Session> create(@Valid @RequestBody CreateSessionDTO in){
    Session s = new Session(
      null,
      UUID.fromString("00000000-0000-0000-0000-000000000001"),
      in.workoutId(),
      in.sessionDate(),
      in.notes()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(sessions.save(s));
  }

  @PostMapping("/{id}/sets")
  public ResponseEntity<SetEntry> addSet(@PathVariable UUID id, @Valid @RequestBody CreateSetDTO in){
    if (!sessions.existsById(id)) return ResponseEntity.notFound().build();
    SetEntry e = new SetEntry(
      null,
      id,
      in.exerciseId(),
      in.setIndex(),
      in.reps(),
      in.weightKg(),
      in.rpe(),
      Boolean.TRUE.equals(in.isPr())
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(sets.save(e));
  }
}
