package com.adiwave.bookkeeper.jpa.postgresql.repository;

import java.util.List;

import com.adiwave.bookkeeper.jpa.postgresql.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
  List<Tutorial> findByPublished(boolean published);

  List<Tutorial> findByTitleContaining(String title);
}
