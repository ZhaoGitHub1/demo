package com.yizhu.listener;

import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;

public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ApplicationStartingEvent){
            System.out.println("监听器监听到ApplicationStartingEvent事件:"+applicationEvent);
        }
        else if (applicationEvent instanceof ApplicationEnvironmentPreparedEvent){
            System.out.println("监听器监听到ApplicationEnvironmentPreparedEvent事件:"+applicationEvent);
        }
        else if (applicationEvent instanceof ApplicationPreparedEvent){
            System.out.println("监听器监听到ApplicationPreparedEvent事件:"+applicationEvent);
        }
        else if (applicationEvent instanceof ApplicationContextEvent){
            System.out.println("监听器监听到ApplicationContextEvent事件:"+applicationEvent);
        }
        else if (applicationEvent instanceof ApplicationStartedEvent){
            System.out.println("监听器监听到ApplicationStartedEvent事件:"+applicationEvent);
        }
        else if (applicationEvent instanceof ApplicationReadyEvent){
            System.out.println("监听器监听到ApplicationReadyEvent事件:"+applicationEvent);
        }
        else if (applicationEvent instanceof ApplicationFailedEvent){
            System.out.println("监听器监听到ApplicationFailedEvent事件:"+applicationEvent);
        }
        else{
            System.out.println("监听器监听到事件:"+applicationEvent);
        }
    }
}
