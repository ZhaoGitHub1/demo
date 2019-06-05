package com.yizhu.controller;

import com.yizhu.dto.UserQueryDto;
import com.yizhu.entity.User;
import com.yizhu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
@Api(tags = "User", description = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("hello world健康检查")
    @GetMapping("/")
    public String index(){
        return "hello world";
    }

    @ApiOperation("通过姓名获取用户信息")
    @GetMapping("/getUserByName")
    public List<User> getName(@RequestParam(value = "name") String name){
        List<User> users = userService.findAllByUserName(name);
        return users;
    }

    @ApiOperation("通过i查询用户信息")
    @GetMapping("/getUserById")
    public User getUserById(@RequestParam(value = "id") Long id){
        return userService.findAllById(id);
    }

    @ApiOperation("获取所有用户信息")
    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @ApiOperation("通过年龄查询用户信息")
    @GetMapping("/getUsersByAge")
    public List<User> getUsersByAge(@RequestParam(value = "age") Integer age){
        return userService.findAllByAge(age);
    }

    @ApiOperation("添加多个用户")
    @PostMapping("/saveAllUsers")
    public String saveAllUsers(@RequestBody List<User> users){
        return userService.saveUsers(users).size() > 0 ? "Success" : "Failed";
    }

    @ApiOperation("添加一个用户")
    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        return userService.saveUser(user) != null ? "Success" : "Failed";
    }

    @ApiOperation("根据用户性别和组织名称查询用户")
    @GetMapping("/getUsersBySexAndOrg")
    public List<User> getUsersBySexAndOrg(@RequestParam("sex") Integer sex, @RequestParam("name") String name){
        return userService.findUsersBySexAndOrg(sex, name);
    }

    @ApiOperation("动态查询用户信息")
    @PostMapping("/getUsersDynamic")
    public List<User> getUsersDynamic(@RequestBody UserQueryDto userQueryDto){
        return userService.findUsersDynamic(userQueryDto);
    }
}
