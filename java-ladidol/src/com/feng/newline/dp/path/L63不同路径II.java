package com.feng.newline.dp.path;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L63不同路径II
 * @author: Ladidol
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 示例 1：
 * 输入：obstacleGrid =
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * @date: 2022/8/16 17:42
 * @version: 1.0
 */
public class L63不同路径II {
    public static void main(String[] args) {
        int[][] nums = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//        System.out.println(new Solution().uniquePathsWithObstacles(nums));
    }

    class Solution {
        //62很像，只是多了一个判断条件。
        //1. 确定dp数组以及下标的含义：dp[i][j]，到达(i+1,j+1)格子的路径总数。
        //2. 确定递推公式：dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //3. dp数组如何初始化：dp[i][0]=1,dp[0][j]=1，在生成dp数组时只要obstacleGrid[i][j] == 1，就直接dp[i][j] = 0;
        // 这里会出现[[1,0]]这样的实例，所以只要碰见有obstacleGrid[i][0]或者obstacleGrid[0][j]==1,后面dp数组就不能初始化为1了
        //4. 确定遍历顺序：二维数组正常遍历(除去上边界和下边界)
        //5. 举例推导dp数组：默认i和j和真实坐标相差一
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[m - 1][n - 1] == 1) {//终点直接不能走的话。
                return 0;
            }
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] == 1) break; //一旦遇到障碍，后续都到不了
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                if (obstacleGrid[0][i] == 1) break; //一旦遇到障碍，后续都到不了
                dp[0][i] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
//                if (obstacleGrid[i - 1][j] != 1 && obstacleGrid[i][j - 1] != 1) {//上左都没有障碍
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                } else if (obstacleGrid[i - 1][j] != 1) {//左碰到障碍
//                    dp[i][j] = dp[i - 1][j];
//                } else if (obstacleGrid[i][j-1] != 1){//上碰到障碍
//                    dp[i][j] = dp[i][j - 1];
//                } else{//左上都被拦截
//                    dp[i][j] = 0;
//                }
                    if (obstacleGrid[i][j] == 1) continue;//只要当前位置有障碍就直接dp=0；
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

}


