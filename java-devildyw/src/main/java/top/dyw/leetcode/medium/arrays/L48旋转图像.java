package top.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-07-27-11:39
 * <p>
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
@SuppressWarnings("all")
public class L48旋转图像 {
    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new L48旋转图像().rotate(ints);
        for (int i = 0; i < ints.length; i++) {
            for (int i1 : ints[i]) {
                System.out.print(i1 + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 先转置 后对称交换就完成了矩阵旋转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        //原地转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j - 1];
                matrix[i][m - j - 1] = temp;
            }
        }
    }
}
