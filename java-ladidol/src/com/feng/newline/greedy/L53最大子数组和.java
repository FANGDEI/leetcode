package com.feng.newline.greedy;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L53最大子数组和
 * @author: Ladidol
 * @description: 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * @date: 2022/8/13 16:27
 * @version: 1.0
 */
public class L53最大子数组和 {
    //贪心贪的是哪里呢？
    //如果 -2 1 在一起，计算起点的时候，一定是从1开始计算，因为负数只会拉低总和，这就是贪心贪的地方！
    //局部最优：当前“连续和”为负数的时候立刻放弃变长，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
    //全局最优：选取最大“连续和”
    //局部最优的情况下，并记录最大的“连续和”，可以推出全局最优。
    class Solution {
        public int maxSubArray(int[] nums) {
            int preSum = 0;
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                if (preSum < 0) {
                    preSum = num;
                } else {
                    preSum += num;
                }
                max = Math.max(preSum, max);

            }
            return max;
        }
    }
}
