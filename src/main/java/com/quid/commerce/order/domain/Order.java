package com.quid.commerce.order.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.quid.commerce.component.SerialNumber;
import com.quid.commerce.payment.gateway.model.PaymentResponse;
import com.quid.commerce.product.domain.Product;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String orderNumber;
    @OneToMany(mappedBy = "order", cascade = ALL)
    private List<OrderProduct> products;
    private OrdererInfo ordererInfo;
    private PaymentInfo paymentInfo;
    private Integer totalPrice;
    @Column(unique = true)
    private String idempotencyKey;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Order(OrdererInfo ordererInfo, String idempotencyKey) {
        this.orderNumber = SerialNumber.generate();
        this.ordererInfo = ordererInfo;
        this.paymentInfo = PaymentInfo.init();
        this.idempotencyKey = idempotencyKey;
        this.createdAt = LocalDateTime.now();
        this.orderStatus = OrderStatus.CREATED;
    }

    public static Order create(OrdererInfo ordererInfo, String idempotencyKey) {
        return new Order(ordererInfo, idempotencyKey);
    }

    public void validatePayable() {
        if (this.paymentInfo.getPayStatus() == PayStatus.PAYMENT_COMPLETED) {
            throw new IllegalStateException("이미 결제가 완료된 주문입니다.");
        }
    }

    public boolean isPayed() {
        return this.paymentInfo.getPayStatus() == PayStatus.PAYMENT_COMPLETED;
    }

    public void addProducts(List<Product> foundProducts) {
        this.products = OrderProduct.create(this, foundProducts);
        this.totalPrice = foundProducts.stream().mapToInt(Product::getPrice).sum();
    }

    public boolean isCanceled() {
        return this.paymentInfo.getPayStatus() == PayStatus.PAYMENT_CANCELLED;
    }

    public boolean isThreeDaysPassed() {
        return this.createdAt.plusDays(3).isBefore(LocalDateTime.now());
    }

    public boolean isPaymentStatusNotPaid() {
        return this.paymentInfo.getPayStatus() != PayStatus.PAYMENT_COMPLETED;
    }

    public void cancel() {
        this.orderStatus = OrderStatus.CANCELLED;
    }

    public void delivering() {
        this.orderStatus = OrderStatus.DELIVERING;
    }
}
