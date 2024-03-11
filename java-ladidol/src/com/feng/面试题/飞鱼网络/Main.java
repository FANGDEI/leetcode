package com.feng.面试题.飞鱼网络;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = scan.nextInt();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            if (map.get(tmp) > n / 2) {
                System.out.println(tmp);
            }
        }

    }

    private static void 第五题() {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();

        int[] dp = new int[4];
        int a = 1;
        int b = 2;
        int c = 3;
        int cur = 0;


        for (long i = 4; i <= n; i++) {
            cur = (a + c) % 1000000007;
            ;
            a = b;
            b = c;
            c = cur;
//            dp[(int) (i % 4)] = (dp[(int) (i - 1) % 4] + dp[(int) (i - 3) % 4]) % 1000000007;
        }
        System.out.println(cur);
    }


}