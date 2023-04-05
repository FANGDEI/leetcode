package top.dyw.leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-09-02-11:24
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
@SuppressWarnings("all")
public class L54螺旋矩阵 {
    public static void main(String[] args) {
        System.out.println(new L54螺旋矩阵().spiralOrder(new int[][]{{7}, {8}, {9}}));
    }

    /**
     * 模拟
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int n = matrix.length, m = matrix[0].length;

        int left = 0, right = m - 1, top = 0, bottom = n - 1;

        while (left<=right&&top<=bottom){
            //模拟上侧 从左闭到右闭区间
            for (int j = left; j<=right; j++){
                list.add(matrix[top][j]);
            }

            //模拟左侧 从上开到下闭 区间
            for (int i = top+1; i<=bottom; i++){
                list.add(matrix[i][right]);
            }

            //判断left和right top和bottom是否相等 如果相等 就不用再模拟由左下部分 防止重复
            if (left<right&&top<bottom){
                //模拟下侧 从右开到左开
                for (int j = right-1; j>left; j--){
                    list.add(matrix[bottom][j]);
                }
                //模拟左侧 从下闭到上开
                for (int i = bottom; i>top; i--){
                    list.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }
}
