/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // 把非0的元素移到前面 再把后面的元素全部改为0就行
        int index = 0;
        for(int i = 0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            } 
        }

        for(int i=index; i<nums.length; i++) {
            nums[index++] = 0;
        }
    }
}
// @lc code=end

