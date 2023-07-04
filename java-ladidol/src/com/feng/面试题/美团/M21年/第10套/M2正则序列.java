package com.feng.面试题.美团.M21年.第10套;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/17 22:05
 * @description: {}
 */
public class M2正则序列 {
    /**
     * 注意：不要有重复的数字，tmd
     * 贪心：sort过后，第一个变成1，第二个变成2...
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ans = 0;
        int[] nums = new int[n + 1];
        nums[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
//        System.out.println("nums = " + Arrays.toString(nums));
        for (int i = 1; i <= n; i++) {
            int abs = Math.abs(i - nums[i]);
//            System.out.println("abs = " + abs);
            ans += abs;
        }
        System.out.println(ans);
    }
}
