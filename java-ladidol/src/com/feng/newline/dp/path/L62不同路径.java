package com.feng.newline.dp.path;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L62不同路径
 * @author: Ladidol
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * @date: 2022/8/16 17:23
 * @version: 1.0
 */
public class L62不同路径 {
    //1. 确定dp数组以及下标的含义：dp[i][j]，到达(i+1,j+1)格子的路径总数。
    //2. 确定递推公式：dp[i][j] = dp[i-1][j] + dp[i][j-1];
    //3. dp数组如何初始化：dp[i][0]=1,dp[0][j]=1;
    //4. 确定遍历顺序：二维数组正常遍历(除去上边界和下边界)
    //5. 举例推导dp数组：默认i和j和真实坐标相差一
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int[] ints : dp) {//直接快速初始化
                Arrays.fill(ints, 1);
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
