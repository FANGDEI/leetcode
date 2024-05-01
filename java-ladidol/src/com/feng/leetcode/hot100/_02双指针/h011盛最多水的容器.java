package com.feng.leetcode.hot100._02双指针;

public class h011盛最多水的容器 {


    //贪心，这个贪心有时候看着有点怪，但是你就从外往内收缩就行了
    class Solution {
        /**
         * 参数：[height]
         * 返回值：int
         * 作者： ladidol
         * 描述：emm，贪心，从最大的宽向内部收缩，当且仅当遇到更高的边才有可能存在更大值。
         */
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int ans = 0;
            //一个循环，来从外收紧
            while (left < right) {
                int minHeight = Math.min(height[left], height[right]);
                int area = (right - left) * minHeight;
                ans = Math.max(area, ans);

                //从左开始收缩，只为寻找到大于当前高度的新left
                while (left < right && height[left] <= minHeight) {
                    left++;
                }
                //同理，从又开始收缩高度
                while (left < right && height[right] <= minHeight) {
                    right--;
                }
            }
            return ans;
        }
    }

    //你就从外往内收缩就行了，每次都收缩最短的那一个
    class Solution3222 {
        public int maxArea(int[] height) {
            int ans = 0, left = 0, right = height.length - 1;
            while (left < right) {
                int area = (right - left) * Math.min(height[left], height[right]);
                ans = Math.max(ans, area);
                if (height[left] < height[right]) ++left;
                else --right;
            }
            return ans;
        }
    }



}
