package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-20-12:47
 *
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，
 * 但保留其原始数据。
 *
 * 给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 *
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 */
@SuppressWarnings("all")
public class L566重塑矩阵 {
    public static void main(String[] args) {
        /**
         * [[1,2],[3,4]]
         * 2
         */
        new L566重塑矩阵().matrixReshape01(new int[][]{{1,2},{3,4}},1,4);
    }

    /**
     * 使用一个一维数组存储
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int iLength = mat.length;
        int jLength = mat[0].length;
        if (r*c != iLength*jLength){
            return mat;
        }

        int[] array = new int[iLength * jLength];

        int index = 0;
        for (int i = 0; i < iLength; i++) {
            for (int j = 0; j < jLength; j++) {
                array[index++] = mat[i][j];
            }
        }
        int[][] ints = new int[r][c];
        int iL = ints.length;
        int jL = ints[0].length;

        index = 0;
        for (int i = 0; i < iL; i++) {
            for (int j = 0; j < jL; j++) {
                ints[i][j] = array[index++];
            }
        }
        return ints;
    }

    /**
     * 采用将二维数组以一维数组方式遍历
     * (i,j)→i×n+j n为列数
     * i=x / n 计算出第几行
     * j=x % n 计算出第几列
     * 以一维数组的方式遍历两个二维数组
     * 前提条件: 两个数组总容量相同
     * 通过上述关系我们可以 将mat数组的值填入result数组
     */
    public int[][] matrixReshape01(int[][] mat, int r, int c){
        int iLength = mat.length;
        int jLength = mat[0].length;
        //比较数组大小 如果不匹配则返回原数组
        if (r*c != iLength*jLength){
            return mat;
        }

        int[][] result = new int[r][c];
        //把二维数组当作一维数组遍历 这里相当于遍历两个数组 由于两个数组的行 列关系不同但是总容量相同
        // 通过 i = x/n 和 j = x%n的关系 填入新的数组中
        for (int i = 0; i < iLength * jLength; i++) {
            //result数组的列数为c mat数组的列数为jLength
            result[i/c][i%c] = mat[i/jLength][i%jLength];
        }
        return result;
    }
}
