package com.feng.saike.第二届.初赛;

import java.io.*;
import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/11/24 11:19
 * @description: https://www.luogu.com.cn/problem/P6364
 */
public class S2_1024程序员节发橙子 {

    /**
     * 作者：Ladidol
     * 描述：找正反不降序列，正向遍历和反向遍历求不降序列：顶点取最大值。
     * 值得注意的是要用long类型
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        long[] score = new long[n + 1];
        long[] orange = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Long.valueOf(strs[i - 1]);
            orange[i] = 1;//初始化每个人都可以的到的橘子数。
        }
        for (int i = 2; i <= n; i++) {//正向遍历求正向不降子序列
            if (score[i - 1] < score[i]) orange[i] = orange[i - 1] + 1;
            else if (score[i - 1] == score[i]) orange[i] = orange[i - 1];
        }
        for (int i = n - 1; i >= 1; i--) {//求反着的不降子序列，并把峰顶的人分到橘子取更大值，其余同上
            if (score[i + 1] < score[i]) orange[i] = Math.max(orange[i + 1] + 1, orange[i]);
            if (score[i + 1] == score[i]) orange[i] = orange[i + 1];
        }
        long sum = Arrays.stream(orange).sum();
        System.out.println(sum);
    }

    /**
     * 作者：Ladidol
     * 描述：用的Scanner来接收的
     */
    private static void m1() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] score = new long[n + 1];
        long[] orange = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = scan.nextInt();
            orange[i] = 1;//初始化每个人都可以的到的橘子数。
        }
        for (int i = 2; i <= n; i++) {//正向遍历求正向不降子序列
            if (score[i - 1] < score[i]) orange[i] = orange[i - 1] + 1;
            else if (score[i - 1] == score[i]) orange[i] = orange[i - 1];
        }
        for (int i = n - 1; i >= 1; i--) {//求反着的不降子序列，并把峰顶的人分到橘子取更大值，其余同上
            if (score[i + 1] < score[i]) orange[i] = Math.max(orange[i + 1] + 1, orange[i]);
            if (score[i + 1] == score[i]) orange[i] = orange[i + 1];
        }
        long sum = Arrays.stream(orange).sum();
        System.out.println(sum);
    }
}