package com.cherries.exchange.demo.JpaRepositories;

import com.cherries.exchange.demo.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
