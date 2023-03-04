package com.order.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.model.Order;
import com.order.management.service.OrderService;
import com.order.management.vo.OrderRequest;

@RestController
public class OrderController {
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@PostMapping("/orders")
	private ResponseEntity<?> createOrder(@RequestBody OrderRequest ord) throws Exception {
		Order order = orderService.createOrder(ord);
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}

	@PostMapping("/orders/{id}")
	private ResponseEntity<?> orderUpdate(@PathVariable Long id, @RequestBody OrderRequest ord) throws Exception {
		Order order = orderService.updateOrder(ord, id);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}

	@DeleteMapping("/orders/{id}")
	private ResponseEntity<?> orderDelete(@PathVariable Long id) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.deleteOrder(id));

	}
}
