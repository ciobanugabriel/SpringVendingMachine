package com.example.myspring.entities;

import com.example.myspring.enums.MoneyType;

import javax.persistence.*;

@Entity
@Table(name = "money_loaded")
public class MoneyLoaded {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private MoneyType moneyType;

    private int quantity;


    public MoneyType getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(MoneyType moneyType) {
        this.moneyType = moneyType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
