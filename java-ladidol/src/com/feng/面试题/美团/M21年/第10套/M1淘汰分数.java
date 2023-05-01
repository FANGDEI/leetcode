package com.feng.面试题.美团.M21年.第10套;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/17 21:28
 * @description: {}
 */
public class M1淘汰分数 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), x = scan.nextInt(), y = scan.nextInt();
        //无解
        if (2 * y < n || 2 * x > n) {
            System.out.println(-1);
            return;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);


//        for (int i = n - y - 1; i < n - x - 1; i++) {
//            int m = nums[i];
//            if (m < nums[i + 1]) {
//                System.out.println(m);
//                return;
//            }
//        }
        int pos = 0;
        if (n > x + y) {//取右边撑死最大n-y
            pos = n - y - 1;
        } else if (n <= x + y) {//去左边最小x
            pos = x - 1;
        }
        System.out.println(nums[pos]);

    }
}
