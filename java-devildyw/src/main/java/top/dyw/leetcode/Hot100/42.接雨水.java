/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // 双指针 算出总面积 再减去柱子面积得到最终结果
        int preHeight = 0;
        int left = 0, right = height.length - 1;
        int totalArea = 0;
        int pillarArea = 0;

        while(left <= right) {
            while(left <= right && height[left] <= preHeight) {
                left++;
            }

            while(left <= right && height[right] <= preHeight) {
                right--;
            }

            // if (left <= right) {
                int newHeight = Math.min(height[left], height[right]);
                totalArea += (right - left + 1) * (newHeight - preHeight);
                preHeight = newHeight;
            // }
        }

        for (int i = 0; i<height.length; i++) {
            pillarArea += height[i];
        }

        return totalArea - pillarArea;
    }
}
// @lc code=end

