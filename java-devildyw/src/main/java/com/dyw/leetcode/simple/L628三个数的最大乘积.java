package com.dyw.leetcode.simple;

import java.util.Arrays;

/**
 * @author Devil
 * @date 2022-05-22-12:52
 *
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
@SuppressWarnings("all")
public class L628三个数的最大乘积 {
    public static void main(String[] args) {

    }

    /*
    注意: 1. 当负数和正数同时存在的情况
         2. 只有负数的情况
         3. 只有正数的情况
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[0]*nums[1]*nums[length-1],nums[length-1]*nums[length-2]*nums[length-3]);
    }

    public int maximumProduct01(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
