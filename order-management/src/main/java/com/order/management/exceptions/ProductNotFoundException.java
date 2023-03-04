package com.order.management.exceptions;

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message) {
		super(message);
	}
}
