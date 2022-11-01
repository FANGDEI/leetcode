package com.dyw.leetcode.algorithm.dp;

/**
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 *
 * @author Devil
 * @since 2022-10-31-12:49
 */
@SuppressWarnings("all")
public class L62不同路径 {

    public static void main(String[] args) {
        System.out.println(new L62不同路径().uniquePaths(3,7));
    }

    /**
     * 动态规划 由题可知机器人每次只能向下或向右移动一步  一条路径是指的 从起点到终点的路径 比如(0,0)到(10,0) 只有一条路径 即向右走
     * <p>
     * 1. dp[i][j] 代表从(0,0)出发到(i,j)有dp[i][j] 条不同路径
     * <p>
     * 2. 因为每次只能向下或向右移动一步 所以dp[i][j] 只能有两个方向推导出来即 dp[i-1][j] 和 dp[i][j-1]
     * <p>
     * 3. dp[i][0] = 0，因为从(0,0) 到 (1,0) 的路径只有一条 那么dp[0][j] 同理
     * <p>
     * 4. 遍历顺序：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * <p>
     * 5. 举例递推dp数组  <img src = "https://img-blog.csdnimg.cn/20201209113631392.png">
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        //初始化dp数组
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        //递推
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//                System.out.print(dp[i][j]+" ");
            }
//            System.out.println();
        }
        return dp[m-1][n-1];
    }
}
