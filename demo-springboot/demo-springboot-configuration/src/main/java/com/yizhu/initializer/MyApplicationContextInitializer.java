package com.yizhu.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("自定义初始化器初始化成功！"+configurableApplicationContext);
//        throw new RuntimeException("人为创造的运行时异常,用于测试是否可监听到ApplicationFailedEvent事件");
    }
}
