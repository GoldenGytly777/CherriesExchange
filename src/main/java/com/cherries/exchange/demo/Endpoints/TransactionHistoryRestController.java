package com.cherries.exchange.demo.Endpoints;

import com.cherries.exchange.demo.Services.TransactionService;
import com.cherries.exchange.demo.entities.TransactionHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionHistoryRestController implements CrudController<TransactionHistory,Integer> {

    @Autowired
    private TransactionService transactionService;

    @Override
    @GetMapping("/transactionHistories")
    public List<TransactionHistory> getAddresses() {
        return transactionService.findAll();
    }

    @Override
    @GetMapping("/transactionHistory/{id}")
    public TransactionHistory getAddresses(@PathVariable Integer id) {
        return transactionService.findById(id);
    }
}
