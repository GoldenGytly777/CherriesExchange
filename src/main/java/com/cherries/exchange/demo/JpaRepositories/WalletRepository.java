package com.cherries.exchange.demo.JpaRepositories;

import com.cherries.exchange.demo.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
}
