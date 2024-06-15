package com.adiwave.bookkeeper.jpa.postgresql.controller;

import com.adiwave.bookkeeper.jpa.postgresql.model.Books;
import com.adiwave.bookkeeper.jpa.postgresql.services.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;

    private byte[] bytes;
    private String nameImage;

    @GetMapping("/books")
    public List<Books> getBooks() {
        return booksService.getBooksAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Books> getBooksId(@RequestParam Long id) {
        return booksService.getBooksId(id);
    }

    @PostMapping("/books/upload")
    public void uploadImage(@RequestParam("bookImage") MultipartFile file) throws IOException {

        this.bytes = file.getBytes();
        this.nameImage = file.getOriginalFilename();

    }

    @PostMapping("/books")
    public Books addBook(@RequestBody Books books) {

        books.setImage(this.bytes);
        books.setImageName(this.nameImage);
        return booksService.addBook(books);
    }

    @PutMapping("/books")
    public Books editBook(@RequestBody Books books) throws Exception {
        return booksService.editBook(books);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@RequestParam Long id) {
        booksService.deleteBooksById(id);
    }
}
