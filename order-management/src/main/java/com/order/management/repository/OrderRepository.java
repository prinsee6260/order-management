package com.order.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.management.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
