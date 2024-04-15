package org.egorovav.springmvctest.controller;

import org.egorovav.springmvctest.entitity.Book;
import org.egorovav.springmvctest.repository.AuthorRepository;
import org.egorovav.springmvctest.repository.BookRepository;
import org.egorovav.springmvctest.repository.GenreRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class BookRestController {

    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/books/rest/booklist")
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @PostMapping("/books/rest/addbook")
    Book addBook(@RequestBody Book newEmployee) {
        return bookRepository.save(newEmployee);
    }

    @GetMapping("/books/rest/booklist/{id}")
    Book getBookById(@PathVariable Integer id) {
        return bookRepository.findById(id).get();
    }

    @PutMapping("/employees/{id}")
    Book updateEmployee(@RequestBody Book newBook, @PathVariable Integer id) {

        return bookRepository.findById(id).map(book -> {
            book.setTitle(newBook.getTitle());
            book.setAuthor(newBook.getAuthor());
            book.setGenre(newBook.getGenre());
            return bookRepository.save(book);
        }).orElseGet(() -> {
            newBook.setId(id);
            return bookRepository.save(newBook);
        });
    }

    @DeleteMapping("/books/rest/booklist/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        bookRepository.deleteById(id);
    }
}
