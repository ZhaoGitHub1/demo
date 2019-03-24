package com.yizhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class DemoEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEventApplication.class, args);
    }
}
