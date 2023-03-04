package com.order.management.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.order.management.exceptions.OrderNotFoundException;
import com.order.management.exceptions.ProductNotFoundException;
import com.order.management.exceptions.VendorNotFoundException;
import com.order.management.vo.ErrorResponse;

@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleException(ProductNotFoundException exception) {
		return ResponseEntity.ok(new ErrorResponse(exception.getMessage(), "Product Not Found"));
	}

	@ExceptionHandler(VendorNotFoundException.class)
	public ResponseEntity<Object> handleException(VendorNotFoundException exception) {
		return ResponseEntity.ok(new ErrorResponse(exception.getMessage(), "Vendor Not Found"));
	}

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<Object> handleException(OrderNotFoundException exception) {
		return ResponseEntity.ok(new ErrorResponse(exception.getMessage(), "Order Not Found"));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception exception) {
		return ResponseEntity.ok(new ErrorResponse(exception.getMessage(), " Internal Server Error"));
	}
}