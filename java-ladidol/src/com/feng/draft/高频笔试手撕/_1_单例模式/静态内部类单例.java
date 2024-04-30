package com.feng.draft.高频笔试手撕._1_单例模式;

/**
 * 当外部类 Singleton 被加载的时候，并不会创建静态内部类 SingletonInner 的实例对象。只有当调
 * ⽤ getInstance() ⽅法时， SingletonInner 才会被加载，这个时候才会创建单例对象
 * INSTANCE 。 INSTANCE 的唯⼀性、创建过程的线程安全性，都由 JVM 来保证。
 * 这种⽅式同样简单⾼效，⽆需加锁，线程安全，并且⽀持延时加载
 */
public class 静态内部类单例 {

    private 静态内部类单例() {

    }

    public static 静态内部类单例 getSingleTon() {
        return InnerUtil.INSTANCE;
    }

    private static class InnerUtil {
        private final static 静态内部类单例 INSTANCE = new 静态内部类单例();
    }


}
