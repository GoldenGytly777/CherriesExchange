package com.cherries.exchange.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


@Entity
@Table(name="currency")
@Data
public class Currency {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private  Integer id;

    @Column(name = "code")
    private Integer code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "currency_from")
    private List<TransactionHistory> currency_from;

    @OneToMany(mappedBy = "currency_to")
    private List<TransactionHistory> currency_to;

    @OneToMany(mappedBy = "currency")
    private List<Wallet> currency;

}
