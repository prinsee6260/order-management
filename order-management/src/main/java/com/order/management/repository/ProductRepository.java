package com.order.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.management.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
