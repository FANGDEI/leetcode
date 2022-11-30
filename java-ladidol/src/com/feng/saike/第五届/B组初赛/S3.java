package com.feng.saike.第五届.B组初赛;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: ladidol
 * @date: 2022/11/26 16:24
 * @description:
 */
public class S3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < Math.min(n, m + 1); i++) {
            ans = Math.min(nums[Math.min(n - m + i, n - 1)] - nums[i], ans);
        }
        for (int i = n - 1; i >= Math.max(0, n - m + 1); i++) {
            ans = Math.min(nums[Math.min(n - m + i, n - 1)] - nums[i], ans);
        }


        System.out.println(ans);
    }
}