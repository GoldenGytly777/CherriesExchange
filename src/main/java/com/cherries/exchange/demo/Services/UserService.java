package com.cherries.exchange.demo.Services;

import com.cherries.exchange.demo.JpaRepositories.UserRepository;
import com.cherries.exchange.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@org.springframework.stereotype.Service
public class UserService implements Service<User, Integer> {
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
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no user with id: " + id.toString()));
    }
}
