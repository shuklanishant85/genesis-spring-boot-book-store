package com.genesis.store.exceptions;

public class BookNotFoundException extends Exception {

	private static final long serialVersionUID = 5167916369574832085L;

	public BookNotFoundException(String message, Throwable exception) {
		super(message, exception);
	}

}
