package com.example.myspring.entities;

import com.example.myspring.enums.SlotType;

import javax.persistence.*;

@Entity
@Table(name = "shopping_list")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private SlotType slot;
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setSlot(SlotType slot) {
        this.slot = slot;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SlotType getSlot() {
        return slot;
    }

    public int getQuantity() {
        return quantity;
    }
}
