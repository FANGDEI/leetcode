package com.feng.newline.array;

/**
 * @author: ladidol
 * @date: 2022/10/7 10:42
 * @description: 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * 子数组是数组中的一个连续数字序列。
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,20,30,5,10,50]
 * 输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,20,30,40,50]
 * 输出：150
 * 解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 * 示例 3：
 * <p>
 * 输入：nums = [12,17,15,13,10,11,12]
 * 输出：33
 * 解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 * 示例 4：
 * <p>
 * 输入：nums = [100,10,1]
 * 输出：100
 */
public class L1800最大升序子数组和 {

    // 双指针
    class Solution {
        public int maxAscendingSum(int[] nums) {
            int n = nums.length;
            int ans = nums[0];//默认第一个为最大升序。
            int max = nums[0];
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    max += nums[i + 1];
                    ans = Math.max(ans, max);
                } else {
                    max = nums[i + 1];
                    ans = Math.max(ans, max);
                }
            }
            return ans;
        }
    }
}