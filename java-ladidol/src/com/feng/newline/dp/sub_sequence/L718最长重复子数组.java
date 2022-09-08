package com.feng.newline.dp.sub_sequence;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.sub_sequence
 * @className: L718最长重复子数组
 * @author: Ladidol
 * @description: 给两个整数数组nums1和nums2，返回 两个数组中 公共的 、长度最长的子数组的长度。
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 * @date: 2022/9/9 0:11
 * @version: 1.0
 */
public class L718最长重复子数组 {

    // 二维dp
    class Solution1 {
        // 子数组是：默认连续
        // dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。
        // （特别注意： “以下标i - 1为结尾的A” 标明一定是 以A[i-1]为结尾的字符串 ）
        public int findLength(int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            int ans = 0;

            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    if (nums1[i - 1] == nums2[j - 1])
                        dp[i][j] = dp[i - 1][j - 1] + 1;//就是新加元素如果相等，目标子数组就加一。
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    }


    // 一维dp（滚动数组）
    // 因为连续的原因，可以用滚动数组优化二维dp
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int[][] dp = new int[2][nums2.length + 1];
            int ans = 0;

            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i & 1][j] = dp[(i - 1) & 1][j - 1] + 1;//就是新加元素如果相等，目标子数组就加一。
                    } else {
                        dp[i & 1][j] = 0;//这里为了和二维数组保持一直，不想的的要赋值为0；
                    }
                    ans = Math.max(ans, dp[i & 1][j]);
                }
            }
            return ans;
        }
    }
}
