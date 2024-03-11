package com.feng.面试题.奇安信.选择题;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/3 10:23
 * @description: {}
 */
public class MyClass {
    private MyClass(Object o){
        System.out.println("Object");
    }
    private MyClass(double[] nums){
        System.out.println("double");
    }

    public static void main(String[] args) {
        new MyClass(null);
        new MyClass(new double[]{});
    }

}
