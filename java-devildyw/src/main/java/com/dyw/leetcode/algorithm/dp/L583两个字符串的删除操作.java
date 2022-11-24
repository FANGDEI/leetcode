package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-23-10:39
 */
@SuppressWarnings("all")
public class L583两个字符串的删除操作 {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        /**
         * dp[i][j]: 以i-1为结尾的字符串word1 ，和以j-1为结尾的字符串word2，想要达到相等，所需要删除元素的最少次数
         */
        int[][] dp = new int[n+1][m+1];

        /**
         * 初始化
         * dp[i][0]: word2为空字符串，以i-1为结尾的字符串需要删除多少个元素，才能和word2相同呢，很明显是 dp[i][0] = i;
         * 同理 dp[0][j] = j;
         */
        for (int i = 0; i < n + 1; i++) dp[i][0] = i;
        for (int j = 0; j < m + 1; j++) dp[0][j] = j;

        /**
         * 状态转移方程：
         * 分两种情况 word1[i-1] 和 word2[j-1] 相等与不相等
         * 相等时：根据dp数组定义不用删除元素所以 dp[i][j] = dp[i-1][j-1]
         * 不相等时又可以分为三种情况：
         * 情况一：删除 word1[i-1] 最少操作次数为 dp[i-1][j]+1 在删除一个元素 再加上dp[i-1][j]的值
         * 情况二：删除 word2[j-1] 最少操作次数为 dp[i][j-1]+1
         * 情况三：同时删除 word1[i-1] 和 word2[j-1] 操作的最少次数为 dp[i-1][j-1]+2
         */

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 如果相等 没必要删除 还是和dp[i-1][j-1]相同
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
//                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+2);
//                    因为dp[i - 1][j - 1] + 1等于 dp[i - 1][j] 或 dp[i][j - 1]，(dp[i][j-1] 如果i-1与 j-2 不相同要删除 i-1 时 就等于 dp[i-1][j-1] + 1)
//                    所以递推公式可简化为：dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                }
            }
        }
        return dp[n][m];


    }
}
