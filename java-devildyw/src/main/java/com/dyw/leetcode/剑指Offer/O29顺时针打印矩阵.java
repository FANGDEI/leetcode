package com.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2022-09-02-12:24
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
@SuppressWarnings("all")
public class O29顺时针打印矩阵 {
    public static void main(String[] args) {

    }

    /**
     * 模拟
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix == null || matrix[0].length == 0) {
            return new int[0];
        }

        int n = matrix.length, m = matrix[0].length;
        int[] ans = new int[n * m];
        int index = 0, left = 0, right = m - 1, top = 0, bottom = n - 1;

        while (left<=right&&top<=bottom){
            for (int j = left; j<=right; j++){
                ans[index++] = matrix[top][j];
            }

            for (int i = top+1; i<=bottom; i++){
                ans[index++] = matrix[i][right];
            }

            if (left<right&&top<bottom){
                for (int j = right-1; j>left;j--){
                    ans[index++] = matrix[bottom][j];
                }

                for (int i = bottom; i>top; i--){
                    ans[index++] = matrix[i][left];
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
