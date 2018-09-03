package com.yizhu.java8;

/**
* @author 逸竹
* @Description Lambda表达式实践
* @Date 19:49 2018/8/26
* @Param
* @return
**/
public class LambdaPractice {

    public static void main(String[] args) {

        // java8之前
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        };
        new Thread(runnable).start();

        // Lambda实现
        new Thread(() -> System.out.println("hello chinese!")).start();

    }
}
