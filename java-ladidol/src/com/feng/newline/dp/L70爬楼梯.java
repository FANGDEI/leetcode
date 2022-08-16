package com.feng.newline.dp;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L70爬楼梯
 * @author: Ladidol
 * @description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * @date: 2022/8/16 15:40
 * @version: 1.0
 */
public class L70爬楼梯 {
    //提示：爬到第一层楼梯有一种方法，爬到二层楼梯有两种方法。
    //那么第一层楼梯再跨两步就到第三层 ，第二层楼梯再跨一步就到第三层。1-》3只能走大步子，2-》3也只能走一个小步子。
    //所以到第三层楼梯的状态可以由第二层楼梯 和 到第一层楼梯状态推导出来，那么就可以想到动态规划了


    //1. 确定dp数组：（dp table）以及下标的含义 dp[i]： 爬到第i层楼梯，有dp[i]种方法
    //2. 确定递推公式：dp[i] = dp[i - 1] + dp[i - 2]
    //3. dp数组如何初始化：dp[1] = 1，dp[2] = 2;//dp[0]没有意义。
    //4. 确定遍历顺序：从前往后
    //5. 举例推导dp数组：1,2,3,5,8
    class Solution {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < dp.length; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
            return dp[n];
        }
    }
}
