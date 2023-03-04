package com.order.management.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.exceptions.OrderNotFoundException;
import com.order.management.exceptions.ProductNotFoundException;
import com.order.management.exceptions.VendorNotFoundException;
import com.order.management.model.Item;
import com.order.management.model.Order;
import com.order.management.model.Product;
import com.order.management.model.Vendor;
import com.order.management.repository.ItemRepository;
import com.order.management.repository.OrderRepository;
import com.order.management.repository.ProductRepository;
import com.order.management.repository.VendorRepository;
import com.order.management.service.OrderService;
import com.order.management.vo.ItemRequest;
import com.order.management.vo.OrderRequest;
import com.order.management.vo.ProductVo;
import com.order.management.vo.VendorVo;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private VendorRepository vendorRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ItemRepository itemRepository;

	@Override

	public Order createOrder(OrderRequest order) throws Exception {
		Order order2 = saveOrder(order, null);

		return orderRepository.save(order2);
	}

	private Order saveOrder(OrderRequest order, Long id) throws ProductNotFoundException, VendorNotFoundException {
		Set<ItemRequest> items = order.getOrderProducts();
		Set<Item> newItems = new HashSet<>();
		for (ItemRequest item : items) {
			ProductVo ord = item.getProduct();
			if (!productRepository.existsById(ord.getId())) {
				throw new ProductNotFoundException(" Product id " + id);
			}
			Set<Vendor> newVendors = new HashSet<>();
			Set<VendorVo> vendors = item.getVendors();
			for (VendorVo vendor : vendors) {
				if (!vendorRepository.existsById(vendor.getId())) {
					throw new VendorNotFoundException("Vendor id " + id);
				}
				newVendors.add(vendorRepository.findById(vendor.getId()).get());
			}
			Item ite = new Item();
			ite.setProduct(productRepository.findById(ord.getId()).get());
			ite.setQty(item.getQty());
			ite.setVendors(newVendors);
			newItems.add(ite);
		}

		List<Item> newItems2 = itemRepository.saveAll(newItems);
		Order order2 = new Order();
		order2.setId(id);
		order2.setDescription(order.getDescription());
		order2.setItems(new HashSet<>(newItems2));
		return order2;
	}

	@Override
	public Order updateOrder(OrderRequest order, Long id) throws Exception {
		if (!orderRepository.existsById(id)) {
			throw new OrderNotFoundException("Order id " + id);
		}
		Order order2 = saveOrder(order, id);

		return orderRepository.save(order2);

	}

	@Override
	public String deleteOrder(Long id) throws Exception {
		if (!orderRepository.existsById(id)) {
			throw new OrderNotFoundException("Order id " + id);
		}
		orderRepository.deleteById(id);
		return "Order deleted succesfully";

	}

}
