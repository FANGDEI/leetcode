package com.dyw.leetcode.algorithm.贪心;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 *
 * @author Devil
 * @since 2022-10-18-10:08
 */
@SuppressWarnings("all")
public class L53最大子数组和 {
    public static void main(String[] args) {

    }

    /**
     * 贪心
     * <p>
     * 局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
     * <p>
     * 全局最优：选取最大“连续和”
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            //每次count+=nums[i]及时更新sum 记录最大值
            sum = Math.max(sum, count); //取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count <= 0) {
                count = 0; // count重置到初始状态 相当于重置最大子序，因为负数一定拉低总和
            }
        }
        return sum;
    }

    public int maxSubArray01(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }

        int sum = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count+=nums[i];
            sum = Math.max(sum,count);
            if (count<=0){
                count = 0;
            }
        }
        return sum;
    }
}
