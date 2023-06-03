package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/06/03 11:07
 **/
@SuppressWarnings("all")
public class OII013二维子矩阵的和 {

    public static void main(String[] args) {

    }

    static class NumMatrix {
        int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    sum += matrix[i][j];
                }
            }
            return sum;
        }
    }

    /**
     * 一维前缀和
     */
    static class NumMatrixPrefixSum {
        int[][] prefixSum;

        public NumMatrixPrefixSum(int[][] matrix) {
            int m = matrix.length;
            //计算前缀和
            if (m>0){
                int n = matrix[0].length;
                prefixSum = new int[m][n+1];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        prefixSum[i][j+1] = prefixSum[i][j] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += prefixSum[i][col2+1] - prefixSum[i][col1];
            }
            return sum;
        }
    }
}
