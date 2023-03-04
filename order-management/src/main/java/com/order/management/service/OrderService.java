package com.order.management.service;

import com.order.management.model.Order;
import com.order.management.vo.OrderRequest;

public interface OrderService {

	Order createOrder(OrderRequest order) throws Exception;

	Order updateOrder(OrderRequest order, Long id) throws Exception;

	 String deleteOrder(Long id) throws Exception;

}
