package com.genesis.store.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class HomeControllerTest {
	private static final String ROOT_API_URI = "http://localhost:8081/";

	@Test
	public void testGetHomePage() {
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(ROOT_API_URI);
			HttpResponse response = client.execute(request);
			assertEquals(HttpStatus.OK.value(), response.getStatusLine().getStatusCode());
		} catch (Exception e) {
			fail();
		}
	}
}
