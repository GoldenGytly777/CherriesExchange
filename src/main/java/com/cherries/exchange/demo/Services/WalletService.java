package com.cherries.exchange.demo.Services;

import com.cherries.exchange.demo.JpaRepositories.WalletRepository;
import com.cherries.exchange.demo.entities.Wallet;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class WalletService implements ServiceTemplate<Wallet,Integer> {
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void deleteObjectById(Integer id) {
        walletRepository.deleteById(id);
    }

    @Override
    public Wallet save(Wallet object) {
        return walletRepository.save(object);
    }

    @Override
    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet findById(Integer id) {
        return walletRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
}
