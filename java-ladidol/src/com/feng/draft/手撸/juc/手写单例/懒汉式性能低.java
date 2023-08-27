package com.feng.draft.手撸.juc.手写单例;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/27 16:29
 * @description: {}
 */
public class 懒汉式性能低 {

    private static 懒汉式性能低 singleton;

    public 懒汉式性能低() {
    }

    public static synchronized 懒汉式性能低 getSingleton() {//方法加锁，所以性能低
        if (singleton == null) {//懒加载
            singleton = new 懒汉式性能低();
        }
        return singleton;
    }
}
