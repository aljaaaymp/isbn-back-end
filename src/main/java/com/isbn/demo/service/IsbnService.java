package com.isbn.demo.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.isbn.demo.model.Author;
import com.isbn.demo.model.Book;
import com.isbn.demo.model.Publisher;

@Component
public interface IsbnService {

    public List<Author> getAllAuthor();
    public Author saveAuthor(Author author);
    public Book getBook(String bookIsbn10);
    public List<Book> getAllBook();
    public Book saveBook(Book book);
    public List<Publisher> getAllPublisher();
    public Publisher savePublisher(Publisher publisher);
    public Book addAuthorsBook(int bookId, int authorId); 
    public Book assignPublisherToBook(int bookId, int publisherId);
    
}
