package com.example.myspring.entities;

import com.example.myspring.enums.MoneyType;

import javax.persistence.*;

@Entity
@Table(name = "user_wallet")
public class UserWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private MoneyType moneyType;
    private int quantity;

    public UserWallet() {
    }

    public UserWallet(MoneyType moneyTypeCode) {
        this.moneyType = moneyTypeCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int moneyStock) {
        this.quantity = moneyStock;
    }

    public Long getId() {
        return id;
    }

    public MoneyType getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(MoneyType moneyTypeCode) {
        this.moneyType = moneyTypeCode;
    }
}
