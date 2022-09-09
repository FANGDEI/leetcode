package com.feng.newline.dp.sub_sequence;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.sub_sequence
 * @className: L300最长递增子序列
 * @author: Ladidol
 * @description:给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * @date: 2022/9/8 22:37
 * @version: 1.0
 */
public class L300最长递增子序列 {

    // 用回溯暴力求解趋势可以，但是因为只要最大值，不需要过程，这里用dp挺好。

    // 不难发现：就是从中按顺序（可以不连续）取出递增序列。
    // dp[i]的定义：dp[i]表示i之前包括i的以nums[i]结尾最长上升子序列的长度(一定要包括nums[i])
    // 状态转移方程：dp[i] = Math.max{dp[j]+1, dp[i]}  (0~i) (num[i]>num[j])
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);//包括自己的子序列，最初默认值为1；
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j])// 必须保证nums[i]能放到最后一位。
                        dp[i] = Math.max(dp[j] + 1, dp[i]);// dp[i]在重新遍历前面的时候
                }
                ans = Math.max(dp[i], ans);// 可能不包括最后几个元素。
            }
            return ans;
        }
    }
}
