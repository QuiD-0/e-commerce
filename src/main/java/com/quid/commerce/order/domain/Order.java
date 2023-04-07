package com.quid.commerce.order.domain;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.quid.commerce.component.SerialNumber;
import com.quid.commerce.product.domain.Product;
import java.util.List;
import javax.persistence.Entity;
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
    public void validatePayable() {
        if (this.paymentInfo.getPayStatus() == PayStatus.PAYMENT_COMPLETED) {
            throw new IllegalStateException("이미 결제가 완료된 주문입니다.");
        }
    }

    public boolean isPayed() {
        return this.paymentInfo.getPayStatus() == PayStatus.PAYMENT_COMPLETED;
    }
}
