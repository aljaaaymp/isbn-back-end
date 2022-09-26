package com.isbn.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.isbn.demo.model.Author;
import com.isbn.demo.model.Book;
import com.isbn.demo.model.Publisher;
import com.isbn.demo.service.IsbnService;

@SpringBootApplication
public class DemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	
	}
	
	@Bean
	CommandLineRunner run(IsbnService isbnService){
		// adding authors in database
		isbnService.saveAuthor(new Author("Joel", "", "Hartse"));
		isbnService.saveAuthor(new Author("Hannah", "P.", "Templer"));
		isbnService.saveAuthor(new Author("Marguerite", "Z.", "Duras"));
		isbnService.saveAuthor(new Author("Kingsley", "", "Amis"));
		isbnService.saveAuthor(new Author("Fannie Peters", "", "Flagg"));
		isbnService.saveAuthor(new Author("Camille Byron", "", "Paglia"));
		isbnService.saveAuthor(new Author("Rainer Steel", "", "Rilke"));
		
		// adding book in database
		isbnService.saveBook(new Book("Americal Elf", "978-1-891830-85-3", "1-891-83085-6", 1000, "2004", "Book 2","https://cdn.pastemagazine.com/www/articles/2007/01/31/american_elf_volume_2_268x270.jpg"));	
		isbnService.saveBook(new Book("Cosmoknights", "978-1-60309-454-2", "1-603-09454-7", 2000, "2019", "Book 1","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1638801627l/59763475._SX318_.jpg"));
		isbnService.saveBook(new Book("Essex County", "978-1-60309-038-4", "1-603-09038-X", 500, "1990","","https://thecaptivereader.files.wordpress.com/2011/07/essex_county_hardcover_cover_gif_lg.jpg"));
		isbnService.saveBook(new Book("Hey, Mister (Vol 1)", "978-1-891830-02-0", "1-891-83002-3", 1200, "2000", "After School Special","https://www.topshelfcomix.com/catalog/covers/afterschool_lg.jpg"));
		isbnService.saveBook(new Book("The Underwater Welder", "978-1-60309-398-9", "1-603-09398-2", 3000, "2022", "","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1531356658l/13602241._SY475_.jpg"));
	
		// adding publisher in database
		isbnService.savePublisher(new Publisher("Paste Magazine"));
		isbnService.savePublisher(new Publisher("Publishers Weekly"));
		isbnService.savePublisher(new Publisher("Graywolf Press"));
		isbnService.savePublisher(new Publisher("McSweeney's"));

		// adding author/id and publisher/id to book/id
		isbnService.addAuthorsBook(1,1);
		isbnService.addAuthorsBook(1, 2);
		isbnService.addAuthorsBook(1, 3);
		isbnService.assignPublisherToBook(1, 1);

		isbnService.addAuthorsBook(2, 4);
		isbnService.assignPublisherToBook(2, 2);

		isbnService.addAuthorsBook(3, 4);
		isbnService.assignPublisherToBook(3, 3);

		isbnService.addAuthorsBook(4, 2);
		isbnService.addAuthorsBook(4, 5);
		isbnService.addAuthorsBook(4, 6);
		isbnService.assignPublisherToBook(4, 3);

		isbnService.addAuthorsBook(5, 7);
		isbnService.assignPublisherToBook(5, 4);

		return null;

	}

}
