package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Curriculum;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
}
