package com.feng.newline.dp.path;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.path
 * @className: L64最小路径和
 * @author: Ladidol
 * @description: 给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * @date: 2022/8/25 15:11
 * @version: 1.0
 */
public class L64最小路径和 {
    //纯二维
    class Solution {
        public int minPathSum(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];
            dp[0][0] = grid[0][0];
            //初始化dp
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int j = 1; j < dp[0].length; j++) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }
            //取最小的路径，只有两条路径，要么上面来要么下面来。
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    dp[i][j] = dp[i][j - 1] < dp[i - 1][j] ? dp[i][j - 1] + grid[i][j] : dp[i - 1][j] + grid[i][j];
                }
            }
            return dp[grid.length - 1][grid[0].length - 1];
        }
    }
}
