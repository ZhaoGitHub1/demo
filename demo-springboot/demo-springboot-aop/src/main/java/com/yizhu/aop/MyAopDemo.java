package com.yizhu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAopDemo {

    @Before("execution(* com.yizhu..*Controller.*(..))")
    public void beforeController(JoinPoint joinPoint){
        System.out.println("beforeController AOP joinPoint ====== " + joinPoint);
    }

    @Around("execution(* com.yizhu..*Controller.*(..))")
    public String aroundController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundController AOP joinPoint before ====== " + proceedingJoinPoint);
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("aroundController AOP joinPoint after ====== " + proceedingJoinPoint);
        return (String)proceed;
    }

    @After("execution(* com.yizhu..*Controller.*(..))")
    public void afterController(JoinPoint joinPoint){
        System.out.println("afterController AOP joinPoint ====== " + joinPoint);
    }

    @AfterThrowing("execution(* com.yizhu..*.*(..))")
    public void afterThrowing(JoinPoint joinPoint){
        System.out.println("afterThrowing AOP joinPoint ====== " + joinPoint);
    }

    @AfterReturning("execution(* com.yizhu..*Controller.*(..))")
    public void afterControllerReturning(JoinPoint joinPoint){
        System.out.println("afterControllerReturning AOP joinPoint ====== " + joinPoint);
    }

}
