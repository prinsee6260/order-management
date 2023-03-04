package com.order.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.model.Product;
import com.order.management.repository.ProductRepository;
import com.order.management.service.ProductService;
import com.order.management.vo.ProductRequest;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product save(ProductRequest req) {
		Product pro = new Product();
		pro.setDescription(req.getDescription());
		return productRepository.save(pro);

	}

}
