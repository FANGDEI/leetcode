package com.feng.面试题.神策数据;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/11 11:16
 * @description: {}
 */
public class Main {

    static int n = 0;
    static int m = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        int[] nums = new int[m];
        if (n > m) {
            System.out.println(-1);
        }

        for (int i = 0; i < m; i++) {
            nums[i] = scan.nextInt();
        }
        int tmp = 0;
        for (int i = 0; i < m; i++) {
            tmp = Math.max(tmp,nums[i]);
            dfs(nums,1,tmp,i);
        }


    }
    static int ans = 0;

    static void dfs(int[] nums, int day, int cur, int index) {



    }


}
