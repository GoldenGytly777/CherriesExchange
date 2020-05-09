package com.cherries.exchange.demo.Services;

import com.cherries.exchange.demo.JpaRepositories.CurrencyRepository;
import com.cherries.exchange.demo.entities.Currency;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@org.springframework.stereotype.Service
public class CurrencyService implements Service<Currency,Integer> {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public void deleteObjectById(Integer id) {
        currencyRepository.deleteById(id);
    }

    @Override
    public Currency save(Currency object) {
        return currencyRepository.save(object);
    }

    @Override
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency findById(Integer id) {
        return currencyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no currency with id: " + id.toString()));
    }
}
