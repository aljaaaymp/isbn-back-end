package com.isbn.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import com.isbn.demo.model.Author;
import com.isbn.demo.model.Book;
import com.isbn.demo.model.Publisher;
import com.isbn.demo.repository.AuthorRepo;
import com.isbn.demo.repository.BookRepo;
import com.isbn.demo.repository.PublisherRepo;

@Service
@Transactional
public class IsbnServiceImpl implements IsbnService {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private PublisherRepo publisherRepo;

    @Override
    public List<Author> getAllAuthor() {
        return authorRepo.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book getBook(String bookIsbn) {
        Optional<Book> bookIsbn10 = Optional.ofNullable(bookRepo.findByIsbn10(bookIsbn));
        Optional<Book> bookIsbn13 = Optional.ofNullable(bookRepo.findByIsbn13(bookIsbn));

        if (bookIsbn10.isPresent()) {
            return bookIsbn10.get();
        } else {
            if (bookIsbn13.isPresent()) {
                return bookIsbn13.get();
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
            }
        }
    }


    @Override
    public List<Publisher> getAllPublisher() {
        return publisherRepo.findAll();
    }

    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    @Override
    public Book addAuthorsBook(int bookId, int authorId) {

        Book book = bookRepo.findById(bookId);
        Author author = authorRepo.findById(authorId).get();
        book.setAuthorOfBooks(author);
        return book;
    }

    @Override
    public Book assignPublisherToBook(int bookId, int publisherId) {
        Book book = bookRepo.findById(bookId);
        Publisher publisher = publisherRepo.findById(publisherId).get();
        book.setPublisher(publisher);
        return book;
    }

}
