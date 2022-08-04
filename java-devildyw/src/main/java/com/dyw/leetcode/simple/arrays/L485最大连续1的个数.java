package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-18-12:45
 * <p>
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 */
@SuppressWarnings("all")
public class L485最大连续1的个数 {
    public static void main(String[] args) {
        new L485最大连续1的个数().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                count += 1;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}
