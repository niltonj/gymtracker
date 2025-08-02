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
        var payload = new HashMap<String,Object>();
        payload.put("session", s);
        payload.put("sets", sets.findBySessionIdOrderBySetIndexAsc(id));
        return ResponseEntity.ok(payload);
      }).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Session> create(@Valid @RequestBody CreateSessionDTO in){
    Session s = Session.builder()
      .userId(UUID.fromString("00000000-0000-0000-0000-000000000001"))
      .workoutId(in.workoutId())
      .sessionDate(in.sessionDate())
      .notes(in.notes())
      .build();
    return ResponseEntity.status(HttpStatus.CREATED).body(sessions.save(s));
  }

  @PostMapping("/{id}/sets")
  public ResponseEntity<SetEntry> addSet(@PathVariable UUID id, @Valid @RequestBody CreateSetDTO in){
    if (!sessions.existsById(id)) return ResponseEntity.notFound().build();
    SetEntry e = SetEntry.builder()
      .sessionId(id)
      .exerciseId(in.exerciseId())
      .setIndex(in.setIndex())
      .reps(in.reps())
      .weightKg(in.weightKg())
      .rpe(in.rpe())
      .isPr(Boolean.TRUE.equals(in.isPr()))
      .build();
    return ResponseEntity.status(HttpStatus.CREATED).body(sets.save(e));
  }
}
