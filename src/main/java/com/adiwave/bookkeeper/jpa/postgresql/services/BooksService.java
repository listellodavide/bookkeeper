package com.adiwave.bookkeeper.jpa.postgresql.services;

import com.adiwave.bookkeeper.jpa.postgresql.model.Books;
import com.adiwave.bookkeeper.jpa.postgresql.repository.BooksRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Books> getBooksAll() {
        return booksRepository.findAll();
    }

    public Optional<Books> getBooksId(Long id) {
        return booksRepository.findById(id);
    }

    public Books addBook(Books books) {
        return booksRepository.save(books);
    }

    @Transactional
    public Books editBook(Books books) throws Exception {
        Books bookEdit = booksRepository.findById(books.getId()).orElseThrow(() -> new Exception("Book not found"));
        bookEdit.setTitle(books.getTitle());
        bookEdit.setDate(books.getDate());
        bookEdit.setDescription(books.getDescription());
        return bookEdit;
    }

    public void deleteBooksById(Long id) {
        booksRepository.deleteById(id);
    }
}
