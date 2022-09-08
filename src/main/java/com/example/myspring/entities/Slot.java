package com.example.myspring.entities;

import com.example.myspring.enums.ProductType;
import com.example.myspring.enums.SlotType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "slot")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    private SlotType slot;
    @Enumerated
    private ProductType productTypeCode;

    private int price;
    private int stock;


    public SlotType getSlot() {
        return slot;
    }

    public void setSlot(SlotType code) {
        this.slot = code;
    }

    public ProductType getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(ProductType productCode) {
        this.productTypeCode = productCode;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

}
