package top.dyw.leetcode.simple.arrays;

/**
 * @author Devildyw
 * @date 2023/12/27 19:12
 **/
@SuppressWarnings("all")
public class L1572矩阵对角线元素的和 {
    public static void main(String[] args) {
        System.out.println(new L1572矩阵对角线元素的和().diagonalSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public int diagonalSum(int[][] mat) {
        int n = mat[0].length;
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum+=mat[j][j];
        }

        for (int j = 0; j < n; j++) {
            if (2*j==n-1) continue;
            sum+=mat[n-1-j][j];
        }

        return sum;
    }
}
