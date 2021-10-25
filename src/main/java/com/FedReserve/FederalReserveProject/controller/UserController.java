package com.FedReserve.FederalReserveProject.controller;

import com.FedReserve.FederalReserveProject.model.User;
import com.FedReserve.FederalReserveProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        System.out.println("User (" + user.getName() + ") has been added");
        return "New user is added";
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
