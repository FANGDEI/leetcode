package top.dyw.leetcode.Hot100;

public class L48旋转图像 {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        // 对角线对称再水平对称
        int n = matrix.length;
        // 对角线对称
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        // 再左右交换
        for (int i=0; i<n; i++) {
            swap(matrix[i]);
        }
    }

    public void swap(int[] nums) {
        for (int i=0, j=nums.length-1; i<j; i++,j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
