package com.yizhu.demo.pattern.singleton;

/**
 * @author 逸竹
 * @Description 饿汉式单例
 * @Date 14:08 2018/9/1
 * @Param
 * @return
 **/
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() { }
    public static EagerSingleton getInstance() {
        return instance;
    }
}
