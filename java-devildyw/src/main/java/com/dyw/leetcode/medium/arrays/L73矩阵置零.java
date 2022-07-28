package com.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-07-15-15:55
 * <p>
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
@SuppressWarnings("all")
public class L73矩阵置零 {
    public static void main(String[] args) {
        int[][] ints = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new L73矩阵置零().setZeroes(ints);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用标记数组 空间复杂度O(m+n)
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        boolean[] row = new boolean[n]; //记录每一行的标记 作为后面置零的行标志
        boolean[] col = new boolean[m]; //记录每一列的标记 作为后面置零的列标记
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    //初始化标记数组
                    row[i] = col[j] = true;
                }
            }
        }

        //再次遍历数组 将元素的行列下标与标记数组进行比较查看是否生效
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }


}
