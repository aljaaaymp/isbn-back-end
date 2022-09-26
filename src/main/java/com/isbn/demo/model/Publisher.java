package com.isbn.demo.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String publisherName;
    @JsonIgnore
    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;

    public int getId() {
        return this.id;
    }

    public Publisher() {

    }

    public Publisher (String publisherName) {
        this.publisherName = publisherName;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisherName() {
        return this.publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

}
