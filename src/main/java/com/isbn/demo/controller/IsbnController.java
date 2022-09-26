package com.isbn.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.isbn.demo.model.Author;
import com.isbn.demo.model.Book;
import com.isbn.demo.model.Publisher;
import com.isbn.demo.repository.AuthorRepo;
import com.isbn.demo.repository.BookRepo;
import com.isbn.demo.repository.PublisherRepo;
import com.isbn.demo.service.IsbnService;

@RequestMapping("/isbn")
@RestController
@CrossOrigin
public class IsbnController {

    @Autowired
    private IsbnService isbnService;

    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    PublisherRepo publisherRepo;

    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody Author author) {
        isbnService.saveAuthor(author);
        return "Author added";
    }

    @GetMapping("/getAuthor")
    public List<Author> getAllAuthor() {
        return isbnService.getAllAuthor();

    }

    @PostMapping("/book")
    public String addBook(@RequestBody Book book) {
        isbnService.saveBook(book);
        return "Book added";
    }

    @GetMapping("/book")
    public List<Book> getAllBook() {
        return isbnService.getAllBook();
    }

    @GetMapping("/onebook/{bookIsbn}")
    public Book getBook(@PathVariable String bookIsbn) {
        return isbnService.getBook(bookIsbn);

    }

    @PostMapping("/publisher")
    public String addPublisher(@RequestBody Publisher publisher) {
        isbnService.savePublisher(publisher);
        return "Publisher Added";
    }

    @GetMapping("/publisher")
    public List<Publisher> getAllPublisher() {
        return isbnService.getAllPublisher();
    }

    @PutMapping("/{bookId}/authors/{authorId}")
    Book addAuthorsBook(
            @PathVariable int bookId,
            @PathVariable int authorId) {
        return isbnService.addAuthorsBook(bookId, authorId);
    }

    @PutMapping("/{bookId}/publisher/{publisherId}")
    Book assignPublisherToBook(
            @PathVariable int bookId,
            @PathVariable int publisherId) {
        return isbnService.assignPublisherToBook(bookId, publisherId);
    }

}
