package com.adiwave.bookkeeper.jpa.postgresql.repository;


import com.adiwave.bookkeeper.jpa.postgresql.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
