package com.yizhu.controller;

import com.yizhu.entity.User;
import com.yizhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "hello world";
    }

    @GetMapping("/getUserByName")
    public List<User> getName(@RequestParam(value = "name") String name){
        List<User> users = userService.findAllByUserName(name);
        return users;
    }

    @GetMapping("/getUserById")
    public User getUserById(@RequestParam(value = "id") int id){
        return userService.findAllById(id);
    }

    @PostMapping("/saveAllUsers")
    public String saveAllUsers(@RequestBody List<User> users){
        return userService.saveUsers(users).size() > 0 ? "Success" : "Failed";
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        return userService.saveUser(user) != null ? "Success" : "Failed";
    }
}
