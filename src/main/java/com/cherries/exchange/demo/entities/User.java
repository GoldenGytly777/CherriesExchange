package com.cherries.exchange.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private BigInteger id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name" )
    private String last_name;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="role", nullable = false)
    private String role;

    @JsonIgnore
    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private boolean enabled;

    @Column(name="blocked")
    private boolean blocked;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List < Wallet > wallets;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List < TransactionHistory > transactionsHistories;

    @OneToMany(mappedBy = "user")
    List < Address > Addressees;
}
