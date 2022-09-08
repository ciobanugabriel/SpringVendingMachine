package com.example.myspring.entities;

import com.example.myspring.enums.ProductType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "allowed_products")
public class AllowedProductTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    private ProductType productType;

    public AllowedProductTypes(ProductType productType) {
        this.productType = productType;
    }

    public AllowedProductTypes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

}
