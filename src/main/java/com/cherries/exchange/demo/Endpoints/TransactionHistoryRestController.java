package com.cherries.exchange.demo.Endpoints;

import com.cherries.exchange.demo.Services.TransactionService;
import com.cherries.exchange.demo.entities.TransactionHistory;
import com.cherries.exchange.demo.entities.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionHistoryRestController implements CrudController<TransactionHistory,Integer> {

    @Autowired
    private TransactionService transactionService;

    @Override
    @GetMapping("/transactionHistories")
    public List<TransactionHistory> getObjects() {
        return transactionService.findAll();
    }

    @Override
    @GetMapping("/transactionHistory/{id}")
    public TransactionHistory getObject(@PathVariable Integer id) {
        return transactionService.findById(id);
    }

    @PostMapping("/transactionHistory")
    public TransactionHistory createUser(@RequestBody TransactionHistory transactionHistory){
        return transactionService.save(transactionHistory);
    }
}
