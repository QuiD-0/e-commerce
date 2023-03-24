package com.quid.commerce.product.domain;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Keyword {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(unique = true)
    private String keyword;
    @OneToMany(mappedBy = "keyword")
    private Set<ProductGroup> productGroupList;

    private Keyword(String keyword, Set<ProductGroup> productGroupList) {
        this.keyword = keyword;
        this.productGroupList = productGroupList;
    }

    public static Keyword create(String keyword, ProductGroup productGroup) {
        return new Keyword(keyword, Set.of(productGroup));
    }

    public void addProductGroup(ProductGroup productGroup) {
        productGroupList.add(productGroup);
    }
}
