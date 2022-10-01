package com.feng.newline.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ladidol
 * @date: 2022/9/30 20:04
 * @description: 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * 示例 1：
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2：
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 */
public class L面试题01_08零矩阵 {

    // 根据提示就是在得到全部行和列后再处理，用set来去重。
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        rowSet.add(i);
                        colSet.add(j);
                    }
                }
            }
            if (rowSet.size() > 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    for (int row : rowSet) {
                        matrix[row][j] = 0;
                    }
                }
                for (int i = 0; i < matrix.length; i++) {
                    for (int col : colSet) {
                        matrix[i][col] = 0;
                    }
                }
            }
        }
    }
}