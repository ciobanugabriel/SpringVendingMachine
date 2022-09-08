package com.example.myspring.entities;

import com.example.myspring.enums.MoneyType;

import javax.persistence.*;

@Entity
@Table(name = "vm_wallet")
public class MachineWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    private MoneyType moneyType;
    private int quantity;

    public MachineWallet() {
    }

    public MachineWallet(MoneyType moneyTypeCode) {
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
