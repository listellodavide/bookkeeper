package com.adiwave.bookkeeper.jpa.postgresql.services;

import com.adiwave.bookkeeper.jpa.postgresql.model.Author;
import com.adiwave.bookkeeper.jpa.postgresql.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthorAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Author adduthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Author editAuthor(Author author) throws Exception {
        Author authorEdit = authorRepository.findById(author.getId()).orElseThrow(() -> new Exception("Author not found"));
        authorEdit.setName(author.getName());
        authorEdit.setSurname(author.getSurname());
        return authorEdit;
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
