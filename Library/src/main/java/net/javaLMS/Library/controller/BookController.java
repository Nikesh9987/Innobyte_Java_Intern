package net.javaLMS.Library.controller;


import net.javaLMS.Library.entity.Book;
import net.javaLMS.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PutMapping("/books/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updateBook) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setName(updateBook.getName());
            book.setAuthor(updateBook.getAuthor());
            return bookRepository.save(book);
        }
        return null;
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }


}
