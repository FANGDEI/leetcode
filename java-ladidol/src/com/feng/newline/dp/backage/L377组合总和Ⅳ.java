package com.feng.newline.dp.backage;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.backage
 * @className: L377组合总和Ⅳ
 * @author: Ladidol
 * @description: 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 * <p>
 * 输入：nums = [9], target = 3
 * 输出：0
 * @date: 2022/8/31 21:25
 * @version: 1.0
 */
public class L377组合总和Ⅳ {

    // 一维解法
    class Solution {
        // 题意可知这是：排列(注意的就是换一下遍历顺序，先遍历背包，再遍历nums)，背一下公式就能过的。
        // dp[j] += dp[j - nums[i]]
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 0; i <= target; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i >= nums[j]) {
                        dp[i] += dp[i - nums[j]];
                    }
                }
            }
            return dp[target];
        }
    }
}
