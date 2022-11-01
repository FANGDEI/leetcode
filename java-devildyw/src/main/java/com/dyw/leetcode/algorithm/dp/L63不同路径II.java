package com.dyw.leetcode.algorithm.dp;

/**
 * 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * @author Devil
 * @since 2022-10-31-13:52
 */
@SuppressWarnings("all")
public class L63不同路径II {

    public static void main(String[] args) {
        System.out.println(new L63不同路径II().uniquePathsWithObstacles(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    /**
     * 与 L62不同路径思路相同 只是多了一个判断路径上是否有障碍物的判断
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        //如果起点或终点出现障碍物 则没有路径可以到达终点
        if (obstacleGrid[m-1][n-1]==1||obstacleGrid[0][0] == 1){
            return 0;
        }

        //限制 对于没有障碍物的第 0 行和第0列进行初始化 遇到障碍物跳出循环 因为该路径有障碍物而机器人只能向右向下移动 所以后续的点是到达不了的
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //遇到障碍物不做处理 到达不了
                if (obstacleGrid[i][j] == 1){
                    continue;
                }else{
                    dp[i][j] = dp[i][j-1]+dp[i-1][j];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
