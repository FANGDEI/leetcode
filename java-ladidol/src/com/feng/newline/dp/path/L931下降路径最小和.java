package com.feng.newline.dp.path;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.path
 * @className: L931下降路径最小和
 * @author: Ladidol
 * @description: 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * 示例 1：
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * 示例 2：
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：如图所示，为和最小的下降路径
 * 提示：
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 * @date: 2022/8/25 17:08
 * @version: 1.0
 */
public class L931下降路径最小和 {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            //依旧是很普通的一个题，emm就用二维数组来做吧。
            int[][] dp = new int[matrix.length][matrix[0].length];
            for (int j = 0; j < dp.length; j++) {
                dp[0][j] = matrix[0][j];
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {//存在边界问题。
                    if (j == 0) {
                        dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i - 1][j]) + matrix[i][j];
                    } else if (j + 1 == dp[0].length) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j + 1], dp[i - 1][j]), dp[i - 1][j - 1]) + matrix[i][j];
                    }
                }
            }
            return Arrays.stream(dp[dp.length - 1]).min().getAsInt();
        }
    }
}
