package com.example.myspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "machine_transaction")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String vendingMachineName;
    private String products;
    private int price;

    public Transactions() {
    }

    public Transactions(String user, String vendingMachine) {
        this.userName = user;
        this.vendingMachineName = vendingMachine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user) {
        this.userName = user;
    }

    public String getVendingMachineName() {
        return vendingMachineName;
    }

    public void setVendingMachineName(String vendingMachine) {
        this.vendingMachineName = vendingMachine;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
