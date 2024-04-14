package org.egorovav.springmvctest.controller;

import org.egorovav.springmvctest.entitity.Author;
import org.egorovav.springmvctest.entitity.Book;
import org.egorovav.springmvctest.entitity.Genre;
import org.egorovav.springmvctest.repository.AuthorRepository;
import org.egorovav.springmvctest.repository.BookRepository;
import org.egorovav.springmvctest.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class BookListController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public BookListController(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/books/booklist")
    public String getBookList(Model uiModel) {

        List<Book> books = bookRepository.findAll();
        books.sort(Comparator.comparing(Book::getTitle));
        uiModel.addAttribute("books", books);
        return "booklist";
    }

    @GetMapping("/books/newbook")
    public String showAddBookForm(Book book, Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres", genres);
        return "addbook";
    }

    @PostMapping("/books/addbook")
    public String addBook(Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addbook";
        }

        bookRepository.save(book);
        return "redirect:/books/booklist";
    }

    @GetMapping("/books/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres", genres);
        return "updatebook";
    }

    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable("id") int id, Book book,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            book.setId(id);
            return "updatebook";
        }

        bookRepository.save(book);
        return "redirect:/books/booklist";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") int id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        bookRepository.delete(book);
        return "redirect:/books/booklist";
    }
}
