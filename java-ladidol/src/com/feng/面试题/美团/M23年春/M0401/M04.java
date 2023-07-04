package com.feng.面试题.美团.M23年春.M0401;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/4/1 15:54
 * @description: {}
 */

import java.util.Scanner;

public class M04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] xs = new int[n];//杯子容量
        int[] ys = new int[n];//初始
        int[] zs = new int[n];//给杯子加水，会消耗多少法力
        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ys[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            zs[i] = sc.nextInt();
        }
        //对于不同的要求，我们进行判断
        int m = sc.nextInt();
        int[] qs = new int[m];
        for (int i = 0; i < m; i++) {
            qs[i] = sc.nextInt();
        }

        //维护一个前缀和
        int[] pres = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pres[i] += pres[i - 1] + xs[i - 1] - ys[i - 1];
        }
        //遍历到第q个杯子所需要的掺水量，并且计算出最小的魔法使用。
        for (int i = 0; i < m; i++) {
            int q = qs[i];
            int cur = Integer.MAX_VALUE;
            for (int j = 0; j < q; j++) {
                cur = Math.min(cur, (pres[q] - pres[j]) * zs[j]);
            }
            System.out.print(cur + " ");
        }
        sc.close();
    }
}