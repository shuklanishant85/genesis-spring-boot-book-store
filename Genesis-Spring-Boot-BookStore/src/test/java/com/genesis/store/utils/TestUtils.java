package com.genesis.store.utils;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.genesis.store.repository.Book;

public class TestUtils {

	private static final String API_URI = "http://localhost:8081/api/book";

	public static Book createTestBook() {
		Book book = new Book();
		book.setTitle("Spring Boot");
		book.setAuthor("Nishant");
		return book;
	}

	public static ResponseEntity<Book> createPostRequestForAddingBook(Book book) {
		RestTemplate template = new RestTemplate();
		HttpEntity<Book> requestEntity = new HttpEntity<>(book);
		ResponseEntity<Book> response = template.exchange(API_URI, HttpMethod.POST, requestEntity, Book.class);
		return response;
	}

	public static HttpResponse createPostRequestForFetchingBookById(String bookName) {
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(API_URI + "/" + "title/" + bookName);
			return client.execute(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
