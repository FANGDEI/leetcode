package com.feng.面试题.美团.M23年春.M0325;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/28 20:38
 * @description: {}
 */
public class Singleton {

    // 1、私有化构造方法
    public Singleton() {
    }

    // 2、对外提供获取实例的公共方法
    public static Singleton getInstance() {
        return InnerClass.INSTANCE;
    }

    // 定义静态内部类
    private static class InnerClass {
        private final static Singleton INSTANCE = new Singleton();
    }


}
