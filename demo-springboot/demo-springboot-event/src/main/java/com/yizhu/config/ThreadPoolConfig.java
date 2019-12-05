package com.yizhu.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class ThreadPoolConfig implements AsyncConfigurer {

   @Override
   public Executor getAsyncExecutor() {
       ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
       executor.setCorePoolSize(7);
       executor.setMaxPoolSize(42);
       executor.setQueueCapacity(11);
       executor.setThreadNamePrefix("MyExecutor-");
       executor.initialize();
       executor.setWaitForTasksToCompleteOnShutdown(true);  // 设置线程池关闭的时候等待所有任务都完成
       executor.setAwaitTerminationSeconds(60); // 设置线程池中任务的等待时间
       return executor;
   }

   @Override
   public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
       return null;
   }
}