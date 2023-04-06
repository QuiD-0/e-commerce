package com.quid.commerce.order.domain;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.quid.commerce.component.SerialNumber;
import com.quid.commerce.payment.gateway.model.PaymentResponse;
import com.quid.commerce.product.domain.Product;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String orderNumber;
    @OneToMany
    private List<Product> product;
    private OrdererInfo ordererInfo;
    private PaymentInfo paymentInfo;

    private Order(List<Product> product, OrdererInfo ordererInfo) {
        Integer amount = product.stream().mapToInt(Product::getPrice).sum();
        this.orderNumber = SerialNumber.generate();
        this.product = product;
        this.ordererInfo = ordererInfo;
        this.paymentInfo = PaymentInfo.init(amount);
    }

    public static Order create(List<Product> product, OrdererInfo ordererInfo) {
        return new Order(product, ordererInfo);
    }

    public void pay(PaymentResponse paymentResponse) {
        this.paymentInfo.pay(paymentResponse);
    }
}
