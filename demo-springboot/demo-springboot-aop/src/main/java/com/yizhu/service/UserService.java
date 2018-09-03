package com.yizhu.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getCurrentUserName(){
        System.out.println("this is UserService.getCurrentUserName()");
        return "admin";
    }
}
