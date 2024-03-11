package com.feng.面试题.得物;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/29 14:30
 * @description: {}
 */
public class FinallyDemo {
    public static int test() {
        try {
            System.out.println("1111");
            return 1;
        } catch (Exception e) {
//            System.out.println("你好");

            return 2;
        } finally {
            System.out.println("3333");
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
