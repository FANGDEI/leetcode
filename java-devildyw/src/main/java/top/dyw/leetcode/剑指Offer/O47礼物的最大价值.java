package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/03/15 20:50
 **/
@SuppressWarnings("all")
public class O47礼物的最大价值 {
    public static void main(String[] args) {
        System.out.println(new O47礼物的最大价值().maxValue(new int[][]{{1, 2, 5}, {3, 2, 1}}));
    }


    /**
     *
     * 自研动态规划
     */
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                dp[i][j] = Math.max(Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]), dp[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n - 1][m - 1];
    }
}
