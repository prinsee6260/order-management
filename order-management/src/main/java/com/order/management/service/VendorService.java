package com.order.management.service;

import com.order.management.model.Vendor;
import com.order.management.vo.VendorRequest;

public interface VendorService {
   Vendor save(VendorRequest req);
}
