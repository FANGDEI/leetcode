/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            result = Math.max((right - left) * h, result);
            if (height[left] < height[right]) {
                int lastH = height[left];
                // 剪纸 以左边为例 left往左移动时 右边不动这时 底边变短 要想获得更大的面积 那么高一定得增长才行 右边移动时同理
                while (left < right && height[left] <= lastH) {
                    left++;
                }
            } else {
                int lastH = height[right];
                while(left < right && height[right] <= lastH) {
                    right--;
                }
            }
        }
        return result;
    }
}
// @lc code=end

