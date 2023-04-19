package top.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2022-09-02-12:24
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
@SuppressWarnings("all")
public class O29顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] ints = {{1,2,3},{4,5,6},{7,8,9}};
        int[] ints1 = new O29顺时针打印矩阵().spiralOrder01(ints);
        for (int i : ints1) {
            System.out.print(i+" ");
        }
    }

    /**
     * 模拟
     *
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

        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                ans[index++] = matrix[top][j];
            }

            for (int i = top + 1; i <= bottom; i++) {
                ans[index++] = matrix[i][right];
            }

            if (left < right && top < bottom) {
                for (int j = right - 1; j > left; j--) {
                    ans[index++] = matrix[bottom][j];
                }

                for (int i = bottom; i > top; i--) {
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

    /**
     * 模拟
     * ------------------>
     * |                 |
     * |                 |
     * |                 |
     * |                 |
     * |                 |
     * |<----------------|
     * @param matrix
     * @return
     */
    public int[] spiralOrder01(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return new int[]{};
        }

        int n = matrix.length, m = matrix[0].length;
        int[] res = new int[n*m];
        int bottom = n-1,top = 0,left = 0,right = m-1;
        int index = 0;
        while (top<=bottom&&left<=right){
            // left -> right
            for (int j = left; j <= right; j++) {
                res[index++] = matrix[top][j];
            }

            //top -> bottom
            for (int i = top + 1; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }

            if (left < right && top < bottom) {
                // right -> left
                for (int j = right - 1; j > left; j--) {
                    res[index++] = matrix[bottom][j];
                }

                //bottom -> top
                for (int i = bottom; i > top; i--) {
                    res[index++] = matrix[i][left];
                }
            }

            top++;
            left++;
            bottom--;
            right--;
        }
        return res;
    }
}
