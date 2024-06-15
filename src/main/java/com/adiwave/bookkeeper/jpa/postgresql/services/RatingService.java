package com.adiwave.bookkeeper.jpa.postgresql.services;

import com.adiwave.bookkeeper.jpa.postgresql.model.Rating;
import com.adiwave.bookkeeper.jpa.postgresql.repository.RatingRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getRatingAll() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> getRatingById(Integer id) {
        return ratingRepository.findById(id);
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Transactional
    public Rating editRating(Rating rating) throws Exception {
        Rating editRating =ratingRepository.findById(rating.getId()).orElseThrow(() -> new Exception("Rating not found"));
        editRating.setRating(rating.getRating());
        editRating.setDateRating(rating.getDateRating());
        return editRating;
    }

    public void deleteRatingId(Integer id) {
        ratingRepository.deleteById(id);
    }
}
