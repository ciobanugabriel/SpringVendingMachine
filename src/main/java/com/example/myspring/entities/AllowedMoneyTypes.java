package com.example.myspring.entities;

import com.example.myspring.enums.MoneyType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "allowed_money")
public class AllowedMoneyTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private MoneyType moneyType;
}
