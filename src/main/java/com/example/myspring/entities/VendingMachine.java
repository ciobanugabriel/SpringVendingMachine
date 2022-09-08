package com.example.myspring.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vending_machine")
public class VendingMachine {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "quantity_money_limit")
    private int qtyMoneyLimit;

    @Column(name = "quantity_slot_limit")
    private int qtySlotLimit;

    @Column(name = "logged_user")
    private Long userId = null;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vm", referencedColumnName = "id")
    private List<Slot> slots = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vm", referencedColumnName = "id")
    private List<MachineWallet> wallet = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vm", referencedColumnName = "id")
    private List<AllowedMoneyTypes> allowedMoneyTypes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vm", referencedColumnName = "id")
    private List<AllowedProductTypes> allowedProductTypes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vm", referencedColumnName = "id")
    private List<MoneyLoaded> moneyLoaded = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vm", referencedColumnName = "id")
    private List<Transactions> transactions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vm", referencedColumnName = "id")
    private List<ShoppingList> shoppingList = new ArrayList<>();

}
