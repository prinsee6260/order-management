package com.order.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="tbl_vendor")
public class Vendor {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String address;
	
	
	

}
