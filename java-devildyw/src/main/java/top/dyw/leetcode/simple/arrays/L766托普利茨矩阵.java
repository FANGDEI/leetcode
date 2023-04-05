package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-06-12-14:41
 * <p>
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * <p>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 */
@SuppressWarnings("all")
public class L766托普利茨矩阵 {
    public static void main(String[] args) {

    }

    /**
     * 矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。 由这一观点可知
     * 居中中的每一个元素都与其左上角相邻的元素(如果存在时)相等时, 就满足上述条件
     *
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                //这里我们从从第一行的第一个元素开始遍历(下标从0开始) 与其左上角的元素进行对比 如果有不相等的情况那么就不是托普利茨矩阵
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        //如果全都满足 那么就是托普利茨矩阵
        return true;
    }
}
