package com.cherries.exchange.demo.Endpoints;

import com.cherries.exchange.demo.Services.UserService;
import com.cherries.exchange.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController implements CrudController<User,Integer> {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/users")
    public List<User> getObjects() {
        return userService.findAll();
    }

    @Override
    @GetMapping("/user/{id}")
    public User getObject(@PathVariable Integer id) {
        return userService.findById(id);
    }

     @PostMapping("/user")
    public User createUser(@RequestBody User user){
        user.setId(0);
        userService.save(user);
        return user;
    }
}
