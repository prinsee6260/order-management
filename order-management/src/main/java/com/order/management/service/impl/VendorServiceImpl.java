package com.order.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.model.Vendor;
import com.order.management.repository.VendorRepository;
import com.order.management.service.VendorService;
import com.order.management.vo.VendorRequest;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public Vendor save(VendorRequest req) {
		Vendor ve = new Vendor();
		ve.setName(req.getName());
		ve.setAddress(req.getAddress());
		return vendorRepository.save(ve);

	}

}
