package com.dyw.leetcode.algorithm.dp;

/**
 *
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 * @author Devil
 * @since 2022-11-08-10:34
 */
@SuppressWarnings("all")
public class L377组合总和Ⅳ {

    public static void main(String[] args) {
        System.out.println(new L377组合总和Ⅳ().combinationSum4(new int[]{1, 2, 3}, 4));
    }

    /**
     * 完全背包
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        /**
         * dp[i] 表示装满容量为i的背包的最大排列数为 dp[i];
         */
        int[] dp = new int[target+1];
        dp[0] = 1;

        /**
         * 外围遍历背包 内层遍历nums数组 代表装满每个容量的背包有多少中排列方式  例如：那么就是先把1加入计算，然后再把5加入计算，得到的方法数量只有{1, 5}这种情况。而不会出现{5, 1}的情况。
         * 内层遍历背包 外层遍历nums数组 代表装满每个容量的背包有多少中组合方式  例如：背包容量的每一个值，都是经过 1 和 5 的计算，包含了{1, 5} 和 {5, 1}两种情况。
         */
        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i>=nums[j]){
                    System.out.println("nums["+j+"]"+nums[j]);
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
