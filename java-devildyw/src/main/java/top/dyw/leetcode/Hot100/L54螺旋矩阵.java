package top.dyw.leetcode.Hot100;

import java.util.ArrayList;
import java.util.List;

public class L54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int top = 0, bottom = n-1, left = 0, right = m-1;
        List<Integer> result = new ArrayList<>();
        while (top <= bottom && left <= right) {
            for (int j=left; j<=right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            for (int i=top; i<=bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom && left <= right) {
                for (int j=right; j>=left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
                for(int i=bottom; i>=top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
