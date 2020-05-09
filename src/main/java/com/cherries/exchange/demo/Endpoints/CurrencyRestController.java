package com.cherries.exchange.demo.Endpoints;


import com.cherries.exchange.demo.Services.CurrencyService;
import com.cherries.exchange.demo.entities.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CurrencyRestController implements CrudController<Currency,Integer> {

    @Autowired
    private CurrencyService currencyService;

    @Override
    @GetMapping("/currencies")
    public List<Currency> getAddresses(){
        return currencyService.findAll();
    }

    @Override
    @GetMapping("/currency/{id}")
    public Currency getAddresses(@PathVariable Integer id){
        return currencyService.findById(id);
    }

}
