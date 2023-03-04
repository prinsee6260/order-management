package com.order.management.vo;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
	private Long id;
	private int qty;
	private ProductVo product;
	private Set<VendorVo>vendors;

}