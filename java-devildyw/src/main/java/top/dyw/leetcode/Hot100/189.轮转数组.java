/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start
class Solution {
    // 旋转其实就是翻转
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        rotate(nums, 0 , nums.length-1);
        rotate(nums,0,k-1);
        rotate(nums,k, nums.length-1);
    }

    public void rotate(int[] nums, int L, int R) {
        while (L<R) {
            int temp = nums[L];
            nums[L] = nums[R];
            nums[R] = temp;
            L++;
            R--;
        }
    }
}
// @lc code=end

