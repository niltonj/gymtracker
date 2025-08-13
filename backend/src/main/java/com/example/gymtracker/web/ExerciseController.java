package com.example.gymtracker.web;

import com.example.gymtracker.dto.CreateExerciseDTO;
import com.example.gymtracker.dto.ExerciseDTO;
import com.example.gymtracker.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class ExerciseController {
  private final ExerciseService service;

  @GetMapping public List<ExerciseDTO> list(){ return service.list(); }

  @PostMapping
  public ResponseEntity<ExerciseDTO> create(@Valid @RequestBody CreateExerciseDTO in,
                                           @RequestHeader("X-User-Id") UUID userId){
    return ResponseEntity.status(HttpStatus.CREATED).body(service.create(in, userId));
  }
}
