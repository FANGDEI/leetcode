package com.feng.leetcode.offer._06查找算法;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/23 10:21
 * @description: {}
 */
public class 剑指Offer04二维数组中的查找 {


    //半暴力半二分
    class Solution {
        /**
         * 二分查找每一行的可能
         *
         * @param matrix
         * @param target
         * @return
         */
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) return false;
            for (int i = 0; i < matrix.length; i++) {
                int left = 0;//起点
                int right = matrix[0].length - 1;//终点

                while (left <= right) {
                    int mid = right + left >> 1;
                    if (matrix[i][mid] == target) return true;
                    else if (matrix[i][mid] > target) right = mid - 1;
                    else left = mid + 1;
                }
            }
            return false;
        }
    }
    //模拟二叉搜索树
    class Solution222 {
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
