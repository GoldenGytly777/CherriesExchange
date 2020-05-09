package com.cherries.exchange.demo.Services;

import com.cherries.exchange.demo.JpaRepositories.UserRepository;
import com.cherries.exchange.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class UserService implements ServiceTemplate<User, Integer>{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteObjectById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
}
