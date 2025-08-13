package com.example.gymtracker.repository;

import com.example.gymtracker.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID> {}
