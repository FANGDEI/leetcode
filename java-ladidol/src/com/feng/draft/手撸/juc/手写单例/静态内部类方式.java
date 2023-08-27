package com.feng.draft.手撸.juc.手写单例;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/27 16:31
 * @description: {}
 */
public class 静态内部类方式 {

    //通过静态内部类，实现高效的懒加载。
    private static class SingletonHolder {
        private static final 静态内部类方式 singleton = new 静态内部类方式();
    }

    public 静态内部类方式 getSingleton() {

        return SingletonHolder.singleton;
    }


}
