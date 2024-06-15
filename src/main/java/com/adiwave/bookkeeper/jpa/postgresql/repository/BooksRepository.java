package com.adiwave.bookkeeper.jpa.postgresql.repository;

import com.adiwave.bookkeeper.jpa.postgresql.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
}
