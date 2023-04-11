package com.quid.commerce.delivery.repository.jpa;

import com.quid.commerce.delivery.domain.WayBill;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaWayBillRepository extends JpaRepository<WayBill, Long> {

    Optional<WayBill> findByTrackingNumber(String trackingNumber);

    Optional<WayBill> findByOrder_Id(Long id);

    List<WayBill> findByOrder_OrdererInfo_Name(String ordererName);
}
