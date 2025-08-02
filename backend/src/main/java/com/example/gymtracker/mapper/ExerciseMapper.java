package com.example.gymtracker.mapper;

import com.example.gymtracker.domain.Exercise;
import com.example.gymtracker.dto.ExerciseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
  ExerciseDTO toDTO(Exercise e);
}
