package com.feng.newline.monotonestack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: ladidol
 * @date: 2022/10/3 21:31
 * @description: 给定一个仅包含0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 * <p>
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * 提示：
 * <p>
 * rows == matrix.length
 * cols == matrix[0].length
 * 1 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 */
public class L85最大矩形 {


    //单调栈
    class Solution {
        /**
         * 参数：[matrix]
         * 返回值：int
         * 作者： ladidol
         * 描述：本题可以通过巧妙的方式转化成类似84题求柱状图中最大矩形。
         * 一层一层的得到由前缀和组成的柱状图，同时求解该柱状图 中最大矩形的面积。
         */
        public int maximalRectangle(char[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;

            //可以通过求前缀和来求解当前柱状图。
            //这里先通过累加。


            int[] pre = new int[m + 2];//默认为零。这里默认还是首尾添加零。
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int[] cur = new int[m + 2];//当前柱状图。
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] != '0') {//注意是字符数组matrix
                        cur[j + 1] = 1 + pre[j + 1];
                    }
                }
                //从这里开始就是和84题一样了。
                Deque<Integer> stack = new ArrayDeque<>();
                int curMax = 0;
                for (int j = 0; j < cur.length; j++) {
                    while (!stack.isEmpty() && cur[stack.peek()] > cur[j]) {//寻找第一个最小的
                        int mid = stack.pop();
                        int left = stack.peek();
                        int right = j;
                        int width = right - left - 1;
                        int height = cur[mid];
                        int area = width * height;
                        curMax = Math.max(area, curMax);
                    }
                    stack.push(j);//一定不要忘记了push元素进入stack；
                }
                ans = Math.max(ans, curMax);
                pre = cur;
            }
            return ans;
        }
    }
}