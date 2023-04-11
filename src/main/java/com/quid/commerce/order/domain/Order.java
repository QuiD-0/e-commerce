package com.quid.commerce.order.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.quid.commerce.component.SerialNumber;
import com.quid.commerce.order.controller.request.OrderCreateRequest;
import com.quid.commerce.order.domain.validate.OrderCancelPipe;
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

    private Order(OrdererInfo ordererInfo, String idempotencyKey, List<Product> foundProducts) {
        this.orderNumber = SerialNumber.generate();
        this.ordererInfo = ordererInfo;
        this.paymentInfo = PaymentInfo.init();
        this.idempotencyKey = idempotencyKey;
        this.createdAt = LocalDateTime.now();
        this.orderStatus = OrderStatus.CREATED;
        this.products = OrderProduct.create(this, foundProducts);
        this.totalPrice = foundProducts.stream().mapToInt(Product::getPrice).sum();
    }

    public static Order create(OrderCreateRequest request, List<Product> foundProducts) {
        return new Order(request.ordererInfo(), request.idempotencyKey(), foundProducts);
    }

    public void cancel() {
        OrderCancelPipe.check(this);
        this.orderStatus = OrderStatus.CANCELLED;
        this.getPaymentInfo().cancel();
        products.forEach(OrderProduct::cancel);
    }

    public void delivering() {
        this.orderStatus = OrderStatus.DELIVERING;
    }

    public String paymentId() {
        return this.paymentInfo.getPaymentId();
    }

    public void pay(PaymentResponse paymentResponse) {
        paymentInfo.pay(paymentResponse);
    }
}
