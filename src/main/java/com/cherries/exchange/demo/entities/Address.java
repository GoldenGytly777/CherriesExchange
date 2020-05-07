package com.cherries.exchange.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="address")
@Data
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private BigInteger id;

    @Column(name = "country")
    private  String country;

    @Column(name = "city")
    private  String city;

    @Column(name = "street")
    private  String street;

    @Column(name = "house_number")
    private  String house_number;

    @Column(name = "zip_code")
    private  String zip_code;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
