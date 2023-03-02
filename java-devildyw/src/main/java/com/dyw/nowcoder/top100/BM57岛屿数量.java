package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2023-02-09-22:57
 */
@SuppressWarnings("all")
public class BM57岛屿数量 {

    public static void main(String[] args) {

    }

    public int solve(char[][] grid) {
        // write code here
        int n = grid.length;
        if (n == 0) {
            //空矩阵
            return 0;
        }

        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //遇到1的情况
                if (grid[i][j] == '1') {
                    count++;//计数
                    //将该点的相邻的为1的位置置为0
                    dfs(grid, i, j);
                }
            }
        }
        return count;

    }

    private void dfs(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        //置为零
        grid[i][j] = '0';

        //将其相邻的四个方向的为1 的位置置为1 这样就能保证能够更方便地计算且不会重复只会记录一次这个岛
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid,i-1,j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid,i,j-1);
        }
        if (i + 1 < n && grid[i + 1][j] == '1') {
            dfs(grid,i+1,j);
        }
        if (j + 1 < m && grid[i][j + 1] == '1') {
            dfs(grid,i,j+1);
        }
    }
}
