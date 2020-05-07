package com.cherries.exchange.demo.Services;

import com.cherries.exchange.demo.JpaRepositories.AddressRepository;
import com.cherries.exchange.demo.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AddressService implements ServiceTemplate<Address,Integer> {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void deleteObjectById(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address save(Address object) {
        return addressRepository.save(object);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Integer id) {
        return addressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
}
