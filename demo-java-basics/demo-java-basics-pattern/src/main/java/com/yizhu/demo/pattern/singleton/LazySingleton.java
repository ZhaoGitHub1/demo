package com.yizhu.demo.pattern.singleton;

/**
 * @author 逸竹
 * @Description 懒汉式单例（双重加锁验证）
 * @Date 14:09 2018/9/1
 * @Param
 * @return
 **/
public class LazySingleton {
    private volatile static LazySingleton instance = null;

    private LazySingleton() { }

    public static LazySingleton getInstance() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingleton.class) {
                //第二重判断
                if (instance == null) {
                    instance = new LazySingleton(); //创建单例实例
                }
            }
        }
        return instance;
    }
}
