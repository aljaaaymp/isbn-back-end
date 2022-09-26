package com.isbn.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isbn.demo.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    Book findById(int bookId);  
    Book findByIsbn10(String bookIsbn10);
    Book findByIsbn13(String bookIsbn13);

}
