package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-05-11:42
 */
@SuppressWarnings("all")
public class L494目标和 {
    public static void main(String[] args) {

    }

    /**
     * 动态规划 抽象背包问题
     * <p>
     * 既然为target，那么就一定有 left组合 - right组合 = target。
     * <p>
     * left + right等于sum，而sum是固定的。
     * <p>
     * 公式来了， left - (sum - left) = target -> left = (target + sum)/2 。
     * <p>
     * target是固定的，sum是固定的，left就可以求出来。
     * <p>
     * 假设 加法的总和为 x，那么剑法对应的总和就是 sum-x
     * <p>
     * 所以我们要求的就是 x-(sum-x) = S -> x = (sum + S)/2
     * <p>
     * 问题转换：问题转换为 装满容量为x的背包，有几种方法
     * <p>
     * 1. dp数组及下标的含义：dp[j] 表示填满（包括 j） 这么大容积的包，有dp[j]种方法
     * <p>
     * 2. 递推公式：dp[j] += dp[j - nums[i]] 因为是求总的方法种数 所以需要通过累加 j-num[i] 才能得到
     * <p>
     * 3. 初始化：dp[0] = 1 即装满0容量的背包只有一种方法 那就是不装 后续的所有容量情况也是从dp[0] 递推得到的
     * <p>
     * 4. 确定遍历顺序：nums在外 背包容量在内
     * <p>
     * 5.举例推导 dp数组
     * <img src="https://img-blog.csdnimg.cn/20210125120743274.jpg">
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // x-(sum-x) = taget-> x = (sum+taget)/2
        //如果target+sum 不是偶数 返回0 因为所给元素都为整数 如果向下取整根本满足不了上述等式 所以没有方案
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int size = (target + sum) / 2;
        if (size < 0) size = -size;
        //初始化dp数组
        int[] dp = new int[size+1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j>=nums[i];j--){
                dp[j] += dp[j-nums[i]]; //这里不能加上价值 因为这里计算的不是背包最大价值 而是背包容量下能装下的方法数量
            }
        }

        return dp[size];
    }
}
