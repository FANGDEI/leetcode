package com.feng.面试题.飞鱼网络;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/19 20:19
 * @description: {}
 */
public class TestMain {

    static int b = 3;

    static int sum(int a) {
        int c = 0;

        c += 1;
        b += 2;
        return (a + b + c);

    }


    public static void main(String[] args) {

        int l;
        int a = 2;
        for (int i = 0; i < 5; i++) {
            System.out.print(sum(a)+"， ");
        }

    }

}


















