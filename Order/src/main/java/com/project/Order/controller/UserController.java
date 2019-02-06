package com.project.Order.controller;

import com.project.Order.modal.User;
import com.project.Order.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //******************************************Post method************************************
    @PostMapping()
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping()
    public User findUser(@RequestParam(value = "id")Long userId){
        return userService.findUser(userId);
    }

    @PutMapping("{userId}")
    public User updateUser(@PathVariable Long userId,@RequestBody User user){
        return userService.updateUser(userId,user);
    }
}
