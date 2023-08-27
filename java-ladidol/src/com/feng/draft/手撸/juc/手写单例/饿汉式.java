package com.feng.draft.手撸.juc.手写单例;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/27 16:26
 * @description: {}
 */
public class 饿汉式 {

    private static final 饿汉式 singleton = new 饿汉式();

    public 饿汉式() {
    }

    public static 饿汉式 getSingleton() {
        return singleton;
    }
}
