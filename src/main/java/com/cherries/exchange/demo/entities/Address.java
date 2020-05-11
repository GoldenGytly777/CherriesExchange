package com.cherries.exchange.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

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

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private User user_id;

    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Address_User",
            joinColumns = { @JoinColumn(name = "address_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    Set<User> users = new HashSet<>();

}
