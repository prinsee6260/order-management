package com.order.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.model.Product;
import com.order.management.service.ProductService;
import com.order.management.vo.ProductRequest;

@RestController
public class ProductController {
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping("/products")
	private ResponseEntity<?> createProduct(@RequestBody ProductRequest pro) {
		Product product = productService.save(pro);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

}
