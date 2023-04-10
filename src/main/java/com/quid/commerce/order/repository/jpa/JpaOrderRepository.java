package com.quid.commerce.order.repository.jpa;

import com.quid.commerce.order.domain.Order;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByOrderNumber(String orderNumber);
}
