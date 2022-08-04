package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-23-17:10
 * <p>
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，
 * 都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]]
 * 就是连续递增子序列。
 */
@SuppressWarnings("all")
public class L674最长连续递增序列 {
    public static void main(String[] args) {
        System.out.println(new L674最长连续递增序列().findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }

    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int length = nums.length;
        int num = nums[0];
        int count = 1;
        for (int i = 0; i < length; i++) {
            if (nums[i] <= num) {
                max = Math.max(count, max);
                count = 1;
            } else {
                count++;
            }
            max = Math.max(count, max);
            num = nums[i];
        }
        return max;
    }
}
