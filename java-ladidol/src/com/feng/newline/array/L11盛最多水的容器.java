package com.feng.newline.array;

/**
 * @author: ladidol
 * @date: 2022/10/5 11:35
 * @description: 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 示例 1：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 */
public class L11盛最多水的容器 {


    //双指针（先暴力）TLE了
    class Solution1 {
        /**
         * 参数：[height]
         * 返回值：int
         * 作者： ladidol
         * 描述：似乎只能使用双指针也。看着不能用单调栈了。
         */
        public int maxArea(int[] height) {

            int ans = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    int width = j - i;
                    int high = height[i] > height[j] ? height[j] : height[i];
                    ans = Math.max(width * high, ans);
                }
            }
            return ans;
        }
    }

    //贪心
    class Solution {
        /**
         * 参数：[height]
         * 返回值：int
         * 作者： ladidol
         * 描述：emm，贪心，从最大的宽向内部收缩，当且仅当遇到更高的边才有可能存在更大值。
         */
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int ans = 0;
            while (l < r) {
                int minHeight = Math.min(height[l], height[r]);
                int area = (r - l) * minHeight;
                ans = Math.max(area, ans);
                //这里贪心核心，太秒啦
                while (l < r && height[l] <= minHeight) {//去等于需要注意一下，淘汰之前出现过的高度
                    l++;
                }
                while (l < r && height[r] <= minHeight) {
                    r--;
                }
            }
            return ans;
        }
    }


}