package com.adiwave.bookkeeper.jpa.postgresql.payload;

import com.adiwave.bookkeeper.jpa.postgresql.model.Author;
import com.adiwave.bookkeeper.jpa.postgresql.model.Rating;
import com.adiwave.bookkeeper.jpa.postgresql.model.Typename;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class BookResponse {

    private String id;
    private String title;
    private LocalDate date;
    private String description;
    private String imageName;
    private Typename typeId;
    private Author authorId;
    private Rating ratingId;

    public BookResponse(String id, String title, LocalDate date, String description,
                        String imageName, Typename typeId, Author authorId, Rating ratingId) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
        this.imageName = imageName;
        this.typeId = typeId;
        this.authorId = authorId;
        this.ratingId = ratingId;
    }
}
