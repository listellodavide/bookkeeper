package com.adiwave.bookkeeper.jpa.postgresql.repository;

import com.adiwave.bookkeeper.jpa.postgresql.model.Typename;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Typenamepository extends JpaRepository<Typename, Long> {
}
