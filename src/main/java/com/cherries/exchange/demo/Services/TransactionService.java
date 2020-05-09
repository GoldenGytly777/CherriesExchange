package com.cherries.exchange.demo.Services;

import com.cherries.exchange.demo.JpaRepositories.TransactionHistoryRepository;
import com.cherries.exchange.demo.entities.TransactionHistory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@org.springframework.stereotype.Service
public class TransactionService implements Service<TransactionHistory,Integer> {


    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    @Override
    public void deleteObjectById(Integer id) {
        transactionHistoryRepository.deleteById(id);
    }

    @Override
    public TransactionHistory save(TransactionHistory object) {
        return transactionHistoryRepository.save(object);
    }

    @Override
    public List<TransactionHistory> findAll() {
        return transactionHistoryRepository.findAll();
    }

    @Override
    public TransactionHistory findById(Integer id) {
        return transactionHistoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no transactionHistory with id: " + id.toString()));
    }
}
