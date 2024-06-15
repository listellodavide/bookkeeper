package com.adiwave.bookkeeper.jpa.postgresql.controller;

import com.adiwave.bookkeeper.jpa.postgresql.services.RatingService;
import com.adiwave.bookkeeper.jpa.postgresql.model.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @GetMapping("/ratings")
    public List<Rating> getRatingAll() {
        return ratingService.getRatingAll();
    }

    @GetMapping("/ratings/{id}")
    public Optional<Rating> getRatingById(@RequestParam Integer id) {
        return ratingService.getRatingById(id);
    }

    @PostMapping("/ratings")
    public Rating addRating(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }

    @PutMapping("/ratings")
    public Rating editRating(@RequestBody Rating rating) throws Exception {
        return ratingService.editRating(rating);
    }

    @DeleteMapping("/ratings/{id}")
    public void deleteRatingById(@RequestParam Integer id) {
        ratingService.deleteRatingId(id);
    }
}
