package com.feng.newline.dp;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L213打家劫舍II
 * @author: Ladidol
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 示例1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * @date: 2022/9/2 20:52
 * @version: 1.0
 */
public class L213打家劫舍II {
    class Solution {
        // 因为围成了一个圈：考虑第一个不考虑最后一个，不考虑第一个考虑最后一个。
        public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            int[] dpFirst = new int[nums.length], dpEnd = new int[nums.length];
            dpFirst[0] = nums[0];// 考虑第一个元素。
            dpFirst[1] = Math.max(nums[1], nums[0]);
            dpEnd[0] = 0;//不考虑第一个元素
            dpEnd[1] = nums[1];
            for (int i = 2; i < nums.length; i++) {
                dpEnd[i] = Math.max(dpEnd[i - 1], dpEnd[i - 2] + nums[i]);
                if (i + 1 != nums.length) {//dpFirst不考虑最后一个元素。
                    dpFirst[i] = Math.max(dpFirst[i - 1], dpFirst[i - 2] + nums[i]);
                } else {
                    dpFirst[i] = dpFirst[i - 1];
                }
            }
            return Math.max(dpFirst[nums.length - 1], dpEnd[nums.length - 1]);
        }
    }
}
