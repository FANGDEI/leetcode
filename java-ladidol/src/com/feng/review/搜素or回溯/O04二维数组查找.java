package com.feng.review.搜素or回溯;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/6 10:43
 * @description: {}
 */
public class O04二维数组查找 {


    //模拟二叉搜索树
    class Solution {
        /**
         * @param matrix
         * @param target
         * @return
         */
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) return false;
            int n = matrix.length, m = matrix[0].length;
            int i = 0, j = m - 1;
            while (i < n && j >= 0) {
                if (matrix[i][j] < target) i++;
                else if (matrix[i][j] > target) j--;
                else return true;
            }
            return false;
        }
    }

}
