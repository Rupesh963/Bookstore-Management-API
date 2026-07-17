package com.projectlabs.bookstore_api.controller;

import com.projectlabs.bookstore_api.entity.Author;
import com.projectlabs.bookstore_api.entity.Book;
import com.projectlabs.bookstore_api.repository.AuthorRepository;
import com.projectlabs.bookstore_api.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book, @RequestParam Long authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author == null) {
            throw new RuntimeException("Author not found with id: " + authorId);
        }
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) return null;
        book.setTitle(updatedBook.getTitle());
        book.setPrice(updatedBook.getPrice());
        book.setPublicationYear(updatedBook.getPublicationYear());
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
