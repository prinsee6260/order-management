package com.order.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.management.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
