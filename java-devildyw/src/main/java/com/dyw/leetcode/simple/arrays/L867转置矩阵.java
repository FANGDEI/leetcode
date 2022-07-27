package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-06-21-12:44
 */
@SuppressWarnings("all")
public class L867转置矩阵 {
    public static void main(String[] args) {
        int[][] transpose = new L867转置矩阵().transpose(new int[][]{{1, 2, 3}, {4, 5, 6}});
        for (int[] ints : transpose) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i] + " ");
            }
            System.out.println();
        }
    }

    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][i] = matrix[i][j];
            }
        }

        return res;
    }
}
