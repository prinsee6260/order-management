package com.order.management.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_item")
public class Item {
	@Id
	@GeneratedValue
	private Long id;
	private int qty;
	@ManyToOne
	@JoinColumn(name = "Product_id")
	private Product product;
	@ManyToMany
	@JoinTable(name = "tbl_Item_Vendor", joinColumns = { @JoinColumn(name = "Item_id") }, inverseJoinColumns = {
			@JoinColumn(name = "Vendor_id") })
	private Set<Vendor> vendors;
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private Order order;

}
