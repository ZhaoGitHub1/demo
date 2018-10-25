package com.yizhu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner, Ordered {
    @Override
    public void run(String... args) {
        System.out.println("自定义CommandLineRunner运行成功！");
    }

    // 实现Ordered接口的方式设置顺序
    @Override
    public int getOrder() {
        return 2;
    }
}
