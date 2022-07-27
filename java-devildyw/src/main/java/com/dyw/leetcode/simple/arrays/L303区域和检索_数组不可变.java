package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-03-13:09
 */
@SuppressWarnings("all")
public class L303区域和检索_数组不可变 {
    private int[] sum;

    /**
     * 前缀和 sum[i+1] = sum[i]+nums[i];
     * sumRange(i,j)=sums[j+1]−sums[i]
     */
    public L303区域和检索_数组不可变(int[] nums) {
        int length = nums.length;
        sum = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right] - sum[left];
    }
}
