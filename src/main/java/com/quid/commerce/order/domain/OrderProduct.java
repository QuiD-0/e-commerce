package com.quid.commerce.order.domain;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.quid.commerce.product.domain.Product;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer price;

    private OrderProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
        this.price = product.getPrice();
    }

    public static List<OrderProduct> create(Order order, List<Product> foundProducts) {
        return foundProducts.stream()
            .map(Product::decreaseStock)
            .map(product -> new OrderProduct(order, product))
            .toList();
    }
}
