package com.order.management.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_order")
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	@OneToMany(mappedBy = "order")
	private Set<Item> items;

}
