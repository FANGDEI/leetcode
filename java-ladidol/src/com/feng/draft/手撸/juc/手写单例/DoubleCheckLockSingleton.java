package com.feng.draft.手撸.juc.手写单例;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/25 21:47
 * @description: {}
 */
public class DoubleCheckLockSingleton {


    /**
     * 由于synchronized的类锁和实例锁不互斥，所以，这里统一属性和方法都用static静态的类锁
     */
    private static volatile DoubleCheckLockSingleton singleton;


    public DoubleCheckLockSingleton() {
    }
    public static DoubleCheckLockSingleton getSingleton() {
        if (singleton == null) {//第一次检查
            synchronized (DoubleCheckLockSingleton.class) {
                if (singleton == null) {//获取锁后第二次检查
                    singleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return singleton;
    }
}
