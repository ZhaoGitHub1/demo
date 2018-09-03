package com.yizhu.quartz.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DemoService {

    public void doSomething(String param1, String param2){
        System.out.printf("param1：%s，param2：%s，执行时间：%s",param1,param2,new Date()).println();
    }
}
