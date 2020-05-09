package com.cherries.exchange.demo.Endpoints;


import com.cherries.exchange.demo.Services.CurrencyService;
import com.cherries.exchange.demo.entities.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CurrencyRestController implements CrudController<Currency,Integer> {

    @Autowired
    private CurrencyService currencyService;

    @Override
    @GetMapping("/currencies")
    public List<Currency> getObjects(){
        return currencyService.findAll();
    }

    @Override
    @GetMapping("/currency/{id}")
    public Currency getObject(@PathVariable Integer id){
        return currencyService.findById(id);
    }

    @PostMapping("/currency")
    public Currency createUser(@RequestBody Currency currency) {
        return currencyService.save(currency);
    }

}
