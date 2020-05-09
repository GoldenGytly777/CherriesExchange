package com.cherries.exchange.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="transaction_history")
@Data
public class TransactionHistory {
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name="value_from")
    private BigDecimal value_from;

    @Column(name="value_to")
    private BigDecimal value_to;

    @Column(name="amount_from")
    private BigDecimal amount_from;

    @Column(name="amount_to")
    private BigDecimal amount_to;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="currency_from")
    private Currency currency_from;

    @ManyToOne
    @JoinColumn(name="currency_to")
    private Currency currency_to;
}
