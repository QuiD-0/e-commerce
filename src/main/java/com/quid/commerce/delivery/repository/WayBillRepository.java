package com.quid.commerce.delivery.repository;

import com.quid.commerce.delivery.domain.WayBill;
import com.quid.commerce.delivery.repository.jpa.JpaWayBillRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface WayBillRepository {

    WayBill save(WayBill wayBill);

    Optional<WayBill> findByTrackingNumber(String trackingNumber);

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
            return jpaWayBillRepository.findByTrackingNumber_TrackingNumber(trackingNumber);
        }
    }
}
