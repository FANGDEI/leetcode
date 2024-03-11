package com.feng.面试题.飞鱼网络;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/19 20:25
 * @description: {}
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        System.out.println(fbi(n + 1));
    }


    static long fbi(long n) {
        if (n <= 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        long a = fbi(n - 1) % 1000000007;
        long b = fbi(n - 3) % 1000000007;
        return (a + b) % 1000000007;

    }


}
