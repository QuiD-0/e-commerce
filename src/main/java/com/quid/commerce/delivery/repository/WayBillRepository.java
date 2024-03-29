package com.quid.commerce.delivery.repository;

import com.quid.commerce.delivery.domain.WayBill;
import com.quid.commerce.delivery.repository.jpa.JpaWayBillRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface WayBillRepository {

    WayBill save(WayBill wayBill);

    Optional<WayBill> findByTrackingNumber(String trackingNumber);

    Optional<WayBill> findByOrder_Id(Long id);

    List<WayBill> findByOrder_OrdererInfo_Name(String ordererName);

    @Repository
    @RequiredArgsConstructor
    class WayBillRepositoryImpl implements WayBillRepository{
        private final JpaWayBillRepository jpaWayBillRepository;

        @Override
        public WayBill save(WayBill wayBill) {
            return jpaWayBillRepository.save(wayBill);
        }

        @Override
        public Optional<WayBill> findByTrackingNumber(String trackingNumber) {
            return jpaWayBillRepository.findByTrackingNumber(trackingNumber);
        }

        @Override
        public Optional<WayBill> findByOrder_Id(Long id) {
            return jpaWayBillRepository.findByOrder_Id(id);
        }

        @Override
        public List<WayBill> findByOrder_OrdererInfo_Name(String ordererName) {
            return jpaWayBillRepository.findByOrder_OrdererInfo_Name(ordererName);
        }
    }
}
