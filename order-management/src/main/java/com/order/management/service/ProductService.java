package com.order.management.service;

import com.order.management.model.Product;
import com.order.management.vo.ProductRequest;

public interface ProductService {
	Product save(ProductRequest req);

}
