package com.cherries.exchange.demo.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
    @Id
    @Column(name="Name")
    private String name;
}
