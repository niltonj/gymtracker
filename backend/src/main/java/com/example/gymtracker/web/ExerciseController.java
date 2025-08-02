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
  public ResponseEntity<ExerciseDTO> create(@Valid @RequestBody CreateExerciseDTO in){
    UUID userId = UUID.fromString("00000000-0000-0000-0000-000000000001");
    return ResponseEntity.status(HttpStatus.CREATED).body(service.create(in, userId));
  }
}
