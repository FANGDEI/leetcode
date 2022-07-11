package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-07-11-9:28
 * <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分
 */
@SuppressWarnings("all")
public class L53最大子数组和 {
    public static void main(String[] args) {
        System.out.println(new L53最大子数组和().maxSubArray(new int[]{-3, -2, -2, -3}));
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        //初始化变量 将最大子序和初始化为数组第一个元素
        int pre = 0, maxAns = nums[0];
        //遍历
        for (int num : nums) {
            //pre是前一个pre+当前数组元素 与当前元素做比较 不难得到
            //如果前一个pre+当前元素<当前元素说明前一个pre是负数 他只会减小结果的值 对提升值没有任何帮助 直接舍弃即可
            pre = Math.max(pre + num, num);
            //更新最大子序和
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
