package com.yizhu.demo.pattern.singleton;

public class SingletonTest {

    public static void main(String[] args) {
        System.out.println("===========饿汉式单例============");
        System.out.println(EagerSingleton.getInstance());
        System.out.println(EagerSingleton.getInstance());
        System.out.println("===========饿汉式单例============");

        System.out.println("===========懒汉式单例============");
        System.out.println(LazySingleton.getInstance());
        System.out.println(LazySingleton.getInstance());
        System.out.println("===========懒汉式单例============");

        System.out.println("===========注册式（静态内部类）单例============");
        System.out.println(StaticSingleton.getInstance());
        System.out.println(StaticSingleton.getInstance());
        System.out.println("===========注册式（静态内部类）单例============");

        System.out.println("===========枚举式单例============");
        System.out.println(EnumSingleton.INSTANCE);
        System.out.println(EnumSingleton.INSTANCE);
        System.out.println("===========枚举式单例============");
    }
}
