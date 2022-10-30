package com.dyw.leetcode.algorithm.dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author Devil
 * @since 2022-10-30-13:45
 */
@SuppressWarnings("all")
public class L70爬楼梯 {

    /*
    1. 确定dp数组（dp table）以及下标的含义
    2. 确定递推公式
    3. dp数组如何初始化
    4. 确定遍历顺序
    5. 举例推导dp数组

     */

    public static void main(String[] args) {
        System.out.println(new L70爬楼梯().climbStairs(4));
    }

    /**
     * 1. dp 数组下标代表含义：dp[i] 代表爬到第i层的方法
     * <p>
     * 2. dp[i] = dp[i-1]+dp[i-2]  首先是dp[i - 1]，上i-1层楼梯，有dp[i - 1]种方法，那么再一步跳一个台阶不就是dp[i]了么。
     * <p>
     * 还有就是dp[i - 2]，上i-2层楼梯，有dp[i - 2]种方法，那么再一步跳两个台阶不就是dp[i]了么。
     * <p>
     * 3. 因为题目给出楼梯数是正整数 所以dp数组可以从1阶开始初始化 dp[1] = 1，dp[2] = 2
     * <p>
     * 4. 从前往后推导 所以从前往后遍历
     *
     * 5. dp[3] = dp[2] + dp[1] : 一次只能爬 1 阶 或 2阶 所以想要爬到第三层要么爬到第一层后 再往第三层爬 要么爬到第二层再往第3层爬
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1; //跳到第一层只有一种方法
        dp[2] = 2; //跳到第二层有两种 1. 先跳到第一层 再跳到第二层 2.直接跳两层

        for (int i = 3; i < n + 1; i++) {

            dp[i] = dp[i-1] + dp[i-2];
            System.out.println(dp[i]);
        }

        return dp[n];

    }
}
