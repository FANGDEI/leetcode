package com.feng.面试题.美团.M24年春.M0309;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main2 {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), q = scan.nextInt();
        int count0 = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int cur = scan.nextInt();
            if (cur == 0) {
                count0++;
                continue;
            }
            sum += cur;
        }
        int l = 0, r = 0;
        while (q-- > 0) {
            l = scan.nextInt();
            r = scan.nextInt();
            System.out.println((sum + (long) count0 * l) + " " + (sum + (long) count0 * r));
        }

    }


}
