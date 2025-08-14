package com.example.gymtracker.service;

import com.example.gymtracker.domain.Exercise;
import com.example.gymtracker.dto.CreateExerciseDTO;
import com.example.gymtracker.dto.ExerciseDTO;
import com.example.gymtracker.mapper.ExerciseMapper;
import com.example.gymtracker.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseService {
  private final ExerciseRepository repo;
  private final ExerciseMapper mapper;

  public ExerciseDTO create(CreateExerciseDTO in, UUID userId){
    Exercise e = new Exercise(
      null,
      in.name(),
      in.muscleGroup(),
      userId
    );
    return mapper.toDTO(repo.save(e));
  }

  public List<ExerciseDTO> list(){
    return repo.findAll().stream().map(mapper::toDTO).toList();
  }
}
