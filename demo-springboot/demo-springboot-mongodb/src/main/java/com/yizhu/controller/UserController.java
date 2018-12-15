package com.yizhu.controller;

import com.yizhu.entity.User;
import com.yizhu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "用户信息")
@RestController("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public void addUser(@ModelAttribute User user){
        userService.addUser(user);
    }

    @ApiOperation("查询所有用户")
    @GetMapping("/getUsersByName/{name}")
    public List<User> getUsers(@PathVariable(name = "name") String name){
        return userService.getUsers(name);
    }

    @ApiOperation("查询所有用户")
    @GetMapping(value = "/getUsers")
    public List<User> getUser(@RequestParam(value = "name")String name,
                              @RequestParam(value = "job")String job){
        return userService.findByNameAndJob(name, job);
    }

    @ApiOperation("查询一个用户")
    @GetMapping(value = "/queryUser")
    public User queryUser(@ModelAttribute User user){
        return userService.queryUser(user);
    }
}
