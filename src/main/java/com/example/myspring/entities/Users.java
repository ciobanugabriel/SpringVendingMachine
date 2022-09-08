package com.example.myspring.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int isAdmin;

    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<UserWallet> wallet = new ArrayList<>();
    public Users(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdmin() {
        return isAdmin;
    }

    public void setAdmin(int admin) {
        isAdmin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserWallet> getWallet() {
        return wallet;
    }

    public void setWallet(List<UserWallet> wallet) {
        this.wallet = wallet;
    }
}
