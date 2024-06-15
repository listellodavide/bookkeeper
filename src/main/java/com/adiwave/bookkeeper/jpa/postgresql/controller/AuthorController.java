package com.adiwave.bookkeeper.jpa.postgresql.controller;

import com.adiwave.bookkeeper.jpa.postgresql.model.Author;
import com.adiwave.bookkeeper.jpa.postgresql.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authorService.getAuthorAll();
    }

    @GetMapping("/authors/{id}")
    public Optional<Author> getAuthorId(@RequestParam Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.adduthor(author);
    }

    @PutMapping("/authors")
    public Author editAuthor(@RequestBody Author author) throws Exception {
        return authorService.editAuthor(author);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthorId(@RequestParam Long id) {
        authorService.deleteAuthor(id);
    }
}
