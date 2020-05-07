package com.cherries.exchange.demo.JpaRepositories;

import com.cherries.exchange.demo.entities.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Integer> {
}
