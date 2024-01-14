package com.feng.面试题.富途;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/13 19:38
 * @description: {}
 * <p>
 * 3
 * 10 10
 * 16 10
 * 44 20
 */
public class Main {

    public static void main(String[] args) {










    }

    private static void 第一题() {
        Scanner scan = new Scanner(System.in);

        //总共有四个
        //k>=m m
        //k>=0.7m
        //k>=0.3m
        //k<0.3m
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            long n = scan.nextLong(), m = scan.nextLong();
            long count = n / m;
            n = n % m;

            if (n == 0) {
                System.out.println(count + " " + m);
                continue;
            }

            if (n >= 0.7 * m) {
                n -= 0.7 * m;
                count++;
            }
            if (n == 0) {
                System.out.println(count + " " + (int) (0.7 * m));
                continue;
            }
            if (n >= 0.3 * m) {
                n -= 0.3 * m;
                count++;
                if (n >= 0.3 * m) {
                    n -= 0.3 * m;
                    count++;
                }

            }
            if (n == 0) {

                System.out.println(count + " " + (int) (0.3 * m));
                continue;
            }


            if (n < 0.3 * m) {
                count++;
                System.out.println(count + " " + n);
            }

        }
    }


}
