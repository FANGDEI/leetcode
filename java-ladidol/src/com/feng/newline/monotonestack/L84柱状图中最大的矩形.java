package com.feng.newline.monotonestack;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/10/3 19:46
 * @description: 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 * 提示：
 * <p>
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 */
public class L84柱状图中最大的矩形 {

    // 单调栈
    class Solution {
        /**
         * 参数：[heights]
         * 返回值：int
         * 作者： ladidol
         * 描述： 类似接雨水那题，通过中间元素寻找左右边界来得到最大值。
         */
        public int largestRectangleArea(int[] heights) {
            //有扩容操作，为的是存在第一个元素的左边界和最后一个元素的右边界。
            int[] newHeights = new int[heights.length + 2];
            int n = newHeights.length;
            newHeights[0] = 0;//左右边界为0
            newHeights[n - 1] = 0;
            for (int i = 1; i < n - 1; i++) {
                newHeights[i] = heights[i - 1];
            }

            Deque<Integer> stack = new ArrayDeque<>();
            int ans = 0;

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {//寻找第一个小于
                    int mid = stack.pop();
                    int left = stack.peek();
                    int right = i;
                    int width = right - left - 1;//维护宽度
                    int height = newHeights[mid];
                    int area = width * height;
                    ans = Math.max(ans, area);
                }
                stack.push(i);
            }

            return ans;
        }
    }
    //方法二：看了一眼三叶姐的题解，可以用左右两个单调栈来做，最后得到左右边界，得到每个矩形当高的矩形就行。略。


}