package com.cherries.exchange.demo.Endpoints;

import com.cherries.exchange.demo.Services.AddressService;
import com.cherries.exchange.demo.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressRestController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public List<Address> getAddresses(){
        return addressService.findAll();
    }

    @GetMapping("/address/{id}")
    public Address getAddresses(@PathVariable Integer id){
        return addressService.findById(id);
    }

}