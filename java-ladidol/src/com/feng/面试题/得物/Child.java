package com.feng.面试题.得物;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/29 14:21
 * @description: {}
 */
public class Child extends Parent{
    static {
        System.out.println("执行静态代码块");
    }

    public Child() {
        System.out.println("执行构造方法");
    }
}
