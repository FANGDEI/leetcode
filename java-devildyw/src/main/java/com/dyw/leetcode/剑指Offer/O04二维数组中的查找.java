package com.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2023-02-28-11:30
 */
@SuppressWarnings("all")
public class O04二维数组中的查找 {
    public static void main(String[] args) {

    }

    /**
     * 每层都进行一次二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (target < matrix[i][0]) {
                return false;
            }
            int left = 0, right = m - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else if (matrix[i][mid] > target) {
                    right = mid - 1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
