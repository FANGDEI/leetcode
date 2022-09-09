package com.feng.newline.dp.sub_sequence;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.sub_sequence
 * @className: L674最长连续递增序列
 * @author: Ladidol
 * @description: 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，
 * 都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * @date: 2022/9/8 23:37
 * @version: 1.0
 */
public class L674最长连续递增序列 {
    //dp[i] = Math.max{dp[i-1]+1, dp[i]} (num[i]>num[i-1]) 也是必须包括当前nums[i]值。
    //和L300题上面的一点点小修改。
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int ans = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1])
                    dp[i] = dp[i - 1] + 1;//这里不需要dp[i]来存，dp[i]只更新一下。
                ans = Math.max(dp[i], ans);
            }
            return ans;
        }
    }
}
