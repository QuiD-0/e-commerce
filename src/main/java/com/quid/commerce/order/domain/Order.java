package com.quid.commerce.order.domain;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.quid.commerce.component.SerialNumber;
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
    @Column(name = "total_price")
    private Integer totalPrice;
    private OrdererInfo ordererInfo;
    private PaymentInfo paymentInfo;

    private Order(List<Product> product, OrdererInfo ordererInfo) {
        this.orderNumber = SerialNumber.generate();
        this.product = product;
        this.ordererInfo = ordererInfo;
        this.paymentInfo = PaymentInfo.init();
        this.totalPrice = product.stream().mapToInt(Product::getPrice).sum();
    }

    public static Order create(List<Product> product, OrdererInfo ordererInfo) {
        return new Order(product, ordererInfo);
    }
}
