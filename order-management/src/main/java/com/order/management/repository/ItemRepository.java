package com.order.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.management.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
