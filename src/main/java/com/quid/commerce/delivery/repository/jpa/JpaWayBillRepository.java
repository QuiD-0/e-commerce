package com.quid.commerce.delivery.repository.jpa;

import com.quid.commerce.delivery.domain.WayBill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaWayBillRepository extends JpaRepository<WayBill, Long> {

    WayBill save(WayBill wayBill);
    Optional<WayBill> findByTrackingNumber_TrackingNumber(String trackingNumber);
}
