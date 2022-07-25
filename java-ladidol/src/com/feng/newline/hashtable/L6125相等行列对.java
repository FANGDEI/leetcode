package com.feng.newline.hashtable;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L6125相等行列对
 * @author: Ladidol
 * @description: 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * <p>
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 * @date: 2022/7/24 10:49
 * @version: 1.0
 */
public class L6125相等行列对 {

    public static void main(String[] args) {
        int[][] nums = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
//        System.out.println(new Solution().equalPairs(nums));
    }

    class Solution {
        Deque<String> strRow = new ArrayDeque<>();//开始题意理解错了, 以为一行一列只能使用一次.所以选择了Deque,用String数组也是可以的
        int[][] gridZhuan;
        int count = 0;
        public int equalPairs(int[][] grid) {
            gridZhuan = new int[grid[0].length][grid.length];

            for (int i = 0; i < grid.length; i++) {
                //初始化strRow的同时转置grid;
                strRow.add(Arrays.toString(grid[i]));
                for (int j = 0; j < grid[0].length; j++) {
                    gridZhuan[j][i] = grid[i][j];
                }
            }
            for (int i = 0; i < gridZhuan.length; i++) {//遍历转置后的数组,方便取出grid的列.
                String sCol = Arrays.toString(gridZhuan[i]);//得到一列的值
                for (int j = 0; j < strRow.size(); j++) {
                    String sRow = strRow.removeFirst();//取出一行来比较
                    if (sRow.equals(sCol)){//比较当前列和行有没有对应的.
                        count++;
                        strRow.addLast(sRow);
                    }else{
                        strRow.addLast(sRow);
                    }
                }
            }
            return count;
        }
    }

}

