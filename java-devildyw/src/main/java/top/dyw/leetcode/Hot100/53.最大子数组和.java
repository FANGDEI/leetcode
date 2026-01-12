/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // 顺序遍历 一旦小于0了 就重新更新
        int sumMax = nums[0];
        int sum = nums[0];

        for(int i=1; i<nums.length; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum+=nums[i];
            }
            
            if (sumMax < sum) {
                sumMax = sum;
            }

        }
        return sumMax;
    }
}
// @lc code=end

