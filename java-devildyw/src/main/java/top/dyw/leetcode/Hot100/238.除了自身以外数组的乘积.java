/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除了自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // fontMulti[i] 表示下标i位置左边的乘积
        int[] fontMulti = new int[n];
        // backMulti[i] 表示下标i位置右边的乘积
        int[] backMulti = new int[n];
        fontMulti[0] = 1;
        backMulti[n-1] = 1;

        for (int i=1; i<n; i++) {
            fontMulti[i] = nums[i-1] * fontMulti[i-1];
        }

        for (int i=n-2; i>=0; i--) {
            backMulti[i] = nums[i+1] * backMulti[i+1] ;
        }

        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            result[i] = backMulti[i] * fontMulti[i];
        }

        return result;
    }
}
// @lc code=end

