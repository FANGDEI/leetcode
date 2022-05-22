package com.dyw.leetcode.simple;

/**
 * @author Devil
 * @date 2022-05-22-15:21
 * <p>
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 */
@SuppressWarnings("all")
public class L643子数组最大平均数I {
    public static void main(String[] args) {

    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int sumMax = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i-k] + nums[i];
            sumMax = Math.max(sumMax, sum);
        }
        return 1.0 * sumMax / k;
    }
}
