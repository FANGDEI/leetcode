package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-18-11:42
 */
@SuppressWarnings("all")
public class L718最长重复子数组 {

    public static void main(String[] args) {
        System.out.println(new L718最长重复子数组().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));

    }

    /**
     * 举例推导dp数组
     * <img src="https://img-blog.csdnimg.cn/2021011215282060.jpg">
     */
    public int findLength(int[] nums1, int[] nums2) {
        /**
         * result
         */
        int result = 0;
        /**
         * dp[i][j]:以下标 i-1结尾的 nums1，以下标 j-1 结尾的nums2，最长重复子数组长度为dp[i][j]
         */
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        /**
         * dp[i][j] 只能由 dp[i-1][j-1] 推导出来。 即当 nums[i-1]和 nums[j-1]相等的时候，dp[i][j] = dp[i-1][j-1]+1; 由此可得 i j都得从 1 开始遍历
         */

        //dp[i][0] dp[0][j] 初始化为0即可 java Int数组默认值为0 方便递推

        /**
         * 遍历顺序：外层遍历 nums1[i] 内层遍历 nums2[i]
         */


        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                //nums1[i-1] 不断从 0~j-1 比对 nums[j-1] 如果有相同的元素代表有重复的元素
                if (nums1[i - 1] == nums2[j - 1]) {
                    //不断更新 dp[i][j]
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    //更新 result 取最大值
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

    public int findLength01(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        int result = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(dp[i][j],result);
                }
            }
        }
        return result;
    }

}
