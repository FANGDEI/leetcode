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

        if (nums[length]>0&&Math.abs(nums[1])>nums[length-3]){
            return nums[0]*nums[1]*nums[length-1];
        }
        return nums[length-3]*nums[length-2]*nums[length-1];
    }
}
