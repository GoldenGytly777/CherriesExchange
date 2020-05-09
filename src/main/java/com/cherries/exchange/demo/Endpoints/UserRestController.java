package com.cherries.exchange.demo.Endpoints;

import com.cherries.exchange.demo.Services.UserService;
import com.cherries.exchange.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController implements CrudController<User,Integer> {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/users")
    public List<User> getAddresses() {
        return userService.findAll();
    }

    @Override
    @GetMapping("/user/{id}")
    public User getAddresses(@PathVariable Integer id) {
        return userService.findById(id);
    }
}
