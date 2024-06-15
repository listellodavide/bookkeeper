package com.adiwave.bookkeeper.jpa.postgresql.repository;


import com.adiwave.bookkeeper.jpa.postgresql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
