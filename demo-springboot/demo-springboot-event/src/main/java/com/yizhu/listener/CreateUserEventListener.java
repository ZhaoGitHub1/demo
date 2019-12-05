package com.yizhu.listener;

import com.yizhu.event.CreateUserEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class CreateUserEventListener implements ApplicationListener<CreateUserEvent> {

    @Async
    @Override
    public void onApplicationEvent(CreateUserEvent createUserEvent) {
        System.out.println("监听到创建用户事件，线程name:"+Thread.currentThread().getName());
    }
}
