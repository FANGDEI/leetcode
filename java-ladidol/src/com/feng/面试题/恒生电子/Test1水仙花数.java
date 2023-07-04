package com.feng.面试题.恒生电子;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/31 21:05
 * @description: {}
 */
public class Test1水仙花数 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = n; i > 10; i--) {
            int length = String.valueOf(i).length();
//            System.out.println("length = " + length);
            if (isRight(i, length)) {
                System.out.println(i);
            }
        }

    }

    static boolean isRight(int num, int n) {
        int sum = 0;
        int temp = num;
        while (num > 0) {
            int cur = num % 10;
            num = num / 10;
            sum += Math.pow(cur, n);
        }
//        System.out.println("sum = " + sum);
        return sum == temp;
    }


}
