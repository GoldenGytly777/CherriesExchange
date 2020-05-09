package com.cherries.exchange.demo.Endpoints;

import com.cherries.exchange.demo.Services.WalletService;
import com.cherries.exchange.demo.entities.User;
import com.cherries.exchange.demo.entities.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WalletRestController implements CrudController<Wallet,Integer> {

    @Autowired
    private WalletService walletService;

    @Override
    @GetMapping("/wallets")
    public List<Wallet> getObjects() {
        return walletService.findAll();
    }

    @Override
    @GetMapping("/wallet/{id}")
    public Wallet getObject(@PathVariable Integer id) {
        return walletService.findById(id);
    }

    @PostMapping("/wallet")
    public Wallet createUser(@RequestBody Wallet wallet){
        return walletService.save(wallet);
    }
}
