package com.isbn.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isbn.demo.model.Publisher;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
    
}
