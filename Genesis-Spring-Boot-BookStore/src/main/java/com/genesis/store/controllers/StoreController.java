package com.genesis.store.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.store.exceptions.BookIdMismatchException;
import com.genesis.store.exceptions.BookNotFoundException;
import com.genesis.store.repository.Book;
import com.genesis.store.repository.BookRepository;

@RestController
@RequestMapping("/api/book")
public class StoreController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);
	@Autowired
	BookRepository bookRepository;

	@GetMapping
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

	@GetMapping("/title/{bookTitle}")
	public List<Book> findByTitle(@PathVariable("bookTitle") String bookTitle) {
		LOGGER.info("get request for Books against Book title {}", bookTitle);
		return bookRepository.findByTitle(bookTitle);
	}

	@GetMapping("/dummybook")
	public Book getDummyBook() {
		LOGGER.info("get request for dummy Book");
		if (bookRepository.count() != 0) {
			return bookRepository.findAll().iterator().next();
		}
		Book book = new Book();
		book.setAuthor("Content Writer");
		book.setId(12345678);
		book.setTitle("Dummy Book");
		bookRepository.save(book);
		return book;
	}

	@GetMapping("/{id}")
	public Book findById(@PathVariable Long id) throws BookNotFoundException {
		if (bookRepository.exists(id)) {
			LOGGER.info("get request for Book against Book id {}", id);
			return bookRepository.findOne(id);
		}
		throw new BookNotFoundException("No Book present with the requested ID", new Exception());
	}

	@PostMapping
	@ResponseStatus(org.springframework.http.HttpStatus.CREATED)
	public Book create(@RequestBody Book book) {
		LOGGER.info("Post request for adding Book with title {} and id {}", book.getTitle(), book.getId());
		return bookRepository.save(book);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) throws BookNotFoundException {
		if (!bookRepository.exists(id)) {
			throw new BookNotFoundException("No Book found with the requested ID", new Exception());
		}
		LOGGER.info("Delete request for Books against Book id {}", id);
		bookRepository.delete(id);
	}

	@PutMapping("/{id}")
	public Book update(@RequestBody Book book, @PathVariable Long id)
			throws BookIdMismatchException, BookNotFoundException {
		LOGGER.info("Put request for new Book against Book id {}", id);
		if (book.getId() != id) {
			throw new BookIdMismatchException("Book and the request Ids donot match.");
		} else if (!bookRepository.exists(id)) {
			throw new BookNotFoundException("No Book found with the requested ID", new Exception());
		}
		return bookRepository.save(book);

	}
}
