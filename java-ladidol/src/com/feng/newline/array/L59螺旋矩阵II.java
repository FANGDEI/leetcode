package com.feng.newline.array;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L59螺旋矩阵II
 * @author: Ladidol
 * @description: 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 示例:
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 思路好好看看代码随想录的, 有启示作用
 * 始终按照 从左到右 从上到下 从右到左 从下到上 填入顺序循环。
 * <p>
 * https://leetcode.cn/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
 * @date: 2022/6/19 11:43
 * @version: 1.0
 */
public class L59螺旋矩阵II {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new L59().generateMatrix(3)));
    }
}

class L59 {
    public int[][] generateMatrix(int n) {
        //先根据转向条件模拟出顺时针的填写数字
        //判断条件有点多
        int t = 0, r = n - 1, d = n - 1, l = 0;
        int[][] res = new int[n][n];
        int tar = n * n;
        int num = 1;
        while(num <= tar){
            //t缩 从左到右
            for (int i = l; i <= r; i++) {
                res[t][i] = num++;
            }
            t++;
            //r缩 从上到下
            for (int i = t; i <= d; i++) {
                res[i][r] = num++;
            }
            r--;
            //d缩 从右到左
            for (int i = r; i >= l; i--) {
                res[d][i] = num++;
            }
            d--;
            //l缩 从下到上
            for (int i = d; i >= t; i--) {
                res[i][l] = num++;
            }
            l++;
        }
        return res;


    }
}