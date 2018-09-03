package com.yizhu.demo.pattern.singleton;

/**
 * @author 逸竹
 * @Description 静态内部类实现单例
 * @Date 14:11 2018/9/1
 * @Param
 * @return
 **/
public class StaticSingleton {
    private StaticSingleton() {}

    private static class SingletonHolder {
        private final static StaticSingleton instance = new StaticSingleton();
    }
    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}