package com.feng.newline.dp.path;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.path
 * @className: L1289下降路径最小和II
 * @author: Ladidol
 * @description: 给你一个n x n 整数矩阵arr，请你返回 非零偏移下降路径 数字和的最小值。
 * 非零偏移下降路径 定义为：从arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是[1,5,7] ，所以答案是13 。
 * 示例 2：
 * <p>
 * 输入：grid = [[7]]
 * 输出：7
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * -99 <= grid[i][j] <= 99
 * @date: 2022/8/25 17:22
 * @version: 1.0
 */
public class L1289下降路径最小和II {
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];

            //初始化操作
            for (int[] ints : dp) {//需要初始化为最大值
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            for (int j = 0; j < grid.length; j++) {
                dp[0][j] = grid[0][j];
            }

            for (int i = 1; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int curColIndex = j;
                    int value = grid[i][j];
                    for (int k = 0; k < grid[0].length; k++) {
                        if (k != curColIndex) {//能从上一层到这里的最小值。
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + value);
                        }
                    }
                }
            }

            return Arrays.stream(dp[dp.length - 1]).min().getAsInt();
        }
    }

    //回溯来做，能做出来，但是超时了。太暴力了。
    class Solution2 {
        int[][] grid;
        int res = Integer.MAX_VALUE;

        public int minFallingPathSum(int[][] grid) {
            this.grid = grid;
            backtracking(0, 0, -1);
            return res;
        }

        void backtracking(int pathSum, int rowIndex, int colIndex) {
            if (rowIndex == grid.length) {
                res = Math.min(pathSum, res);
                return;//容易忘记return
            }

            for (int j = 0; j < grid[0].length; j++) {
                if (j != colIndex) {
                    backtracking(pathSum + grid[rowIndex][j], rowIndex + 1, j);
                }
            }
        }
    }


}
