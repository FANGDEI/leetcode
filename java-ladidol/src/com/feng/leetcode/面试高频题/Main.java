package com.feng.leetcode.面试高频题;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


public class Main {

    static int u = 1;
    static int v = 1;
    static int n = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        u = scan.nextInt();
        v = scan.nextInt();
        // scan.nextLine();
        int[] nums = new int[n];
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                while (true) {
                    ans++;
                    if (!set.contains(nums[i])) {
                        set.add(nums[i]);
                        break;
                    }
                }
            }

        }
        System.out.print(ans);

    }

    static int ans = 0;

//    static void dfs(int[] nums, int curSum, int curIndex) {
//        if (curIndex == n) {
//            return;
//        }
//        for (int i = curIndex; i < n; i++) {
//            curSum += nums[i];
//            if (curSum / (i - curIndex)) {
//
//            }
//
//        }
//
//    }

}