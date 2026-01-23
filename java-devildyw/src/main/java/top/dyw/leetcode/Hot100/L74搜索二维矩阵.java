package top.dyw.leetcode.Hot100;

public class L74搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从右上角开始走
        int n = matrix.length;
        int m = matrix[0].length;

        int col = m-1;
        int row = 0;
        while (row < n && col >=0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
