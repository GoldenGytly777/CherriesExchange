package com.cherries.exchange.demo.JpaRepositories;

import com.cherries.exchange.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
