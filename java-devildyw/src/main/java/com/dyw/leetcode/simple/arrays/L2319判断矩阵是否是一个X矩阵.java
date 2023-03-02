package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2023-01-31-11:11
 */
@SuppressWarnings("all")
public class L2319判断矩阵是否是一个X矩阵 {
    public static void main(String[] args) {
        System.out.println(new L2319判断矩阵是否是一个X矩阵().checkXMatrix(new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}}));
    }

    public boolean checkXMatrix(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i==j||i+j==grid[0].length-1){
                    if (grid[i][j]==0){
                        return false;
                    }
                }else {
                    if (grid[i][j]!=0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
