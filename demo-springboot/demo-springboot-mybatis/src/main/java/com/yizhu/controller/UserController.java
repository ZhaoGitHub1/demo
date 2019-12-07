package com.yizhu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yizhu.dto.UserQueryByPageDTO;
import com.yizhu.dto.UserQueryDTO;
import com.yizhu.entity.User;
import com.yizhu.service.UserService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
@ApiModel(value = "用户管理", description = "用户相关api接口")
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
        return userService.saveUsers(users) > 0 ? "Success" : "Failed";
    }

    @ApiOperation("添加一个用户")
    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        return userService.saveUser(user) > 0 ? "Success" : "Failed";
    }

    @ApiOperation("根据用户性别和组织名称查询用户")
    @GetMapping("/getUsersBySexAndName")
    public List<User> getUsersBySexAndName(@RequestParam("sex") Integer sex, @RequestParam("name") String name){
        return userService.findUsersBySexAndName(sex, name);
    }

    @ApiOperation("动态查询用户信息")
    @PostMapping("/getUsersDynamic")
    public List<User> getUsersDynamic(@RequestBody UserQueryDTO userQueryDto){
        return userService.findUsersDynamic(userQueryDto);
    }

    @ApiOperation("分页查询用户信息")
    @PostMapping("/getUsersByPage")
    public Page<User> getUsersByPage(@RequestBody UserQueryByPageDTO userQueryByPageDTO){
        return userService.findUsersByPage(userQueryByPageDTO);
    }
}
