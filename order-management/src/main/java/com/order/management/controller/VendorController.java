package com.order.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.model.Vendor;
import com.order.management.service.VendorService;
import com.order.management.vo.VendorRequest;

@RestController
public class VendorController {
	private VendorService vendorService;

	public VendorController(VendorService vendorService) {
		super();
		this.vendorService = vendorService;
	}

	@PostMapping("/vendors")
	private ResponseEntity<?> createVendor(@RequestBody VendorRequest ven) {
		Vendor vendor = vendorService.save(ven);
		return ResponseEntity.status(HttpStatus.CREATED).body(vendor);

	}

}
