package com.yizhu.controller;

import com.yizhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getCurrentUserName")
    public String getCurrentUserName(){
        System.out.println("this is UserController.getCurrentUserName()");
        return userService.getCurrentUserName();
    }

    @GetMapping("/throwExceptionAop")
    public String throwExceptionAop(){
        System.out.println("this is UserController.throwExceptionAop()");
        throw new RuntimeException();
    }

    @GetMapping("/getCurrentUserId")
    public String getCurrentUserId(){
        System.out.println("this is UserController.getCurrentUserId()");
        return "1";
    }
}
