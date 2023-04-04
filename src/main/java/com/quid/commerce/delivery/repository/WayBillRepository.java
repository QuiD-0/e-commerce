package com.quid.commerce.delivery.repository;

import com.quid.commerce.delivery.domain.WayBill;
import java.util.Optional;

public interface WayBillRepository {

    WayBill save(WayBill wayBill);

    Optional<WayBill> findByTrackingNumber(String trackingNumber);
}
