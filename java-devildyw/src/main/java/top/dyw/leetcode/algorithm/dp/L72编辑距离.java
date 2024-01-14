package top.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-23-11:19
 */
@SuppressWarnings("all")
public class L72编辑距离 {

    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        /**
         * dp[i][j]: word1以i-1结尾字符串 转换为 word2以j-1为结尾的字符串word2所使用的最少操作数 。
         */
        int[][] dp = new int[n+1][m+1];

        /**
         * 初始化： dp[i][0] word2 是空字符串 所以word1 要转换为 word2 需要操作i次
         */
        for (int i = 1; i < n + 1; i++) dp[i][0] = i;
        for (int j = 1; j < m + 1; j++) dp[0][j] = j;

        /**
         * 递推公式
         * 有两种情况：word1[i-1]与word2[j-1]相等与不相等
         * 相等: 就代表不用转换 dp[i][j] = dp[i-1][j-1]
         * 不想等: 不相等又分为三种操作 删 替 增 （删除一方的元素相等于另一方删除元素 并且删除与增加的操作数一致）
         * 操作一：word1删除一个元素，那么就是以下标i - 2为结尾的word1 与 j-1为结尾的word2的最近编辑距离 再加上一个操作。
         *
         * 操作二：word2删除一个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的最近编辑距离 再加上一个操作。
         *
         * 操作三：替换元素，word1替换word1[i - 1]，使其与word2[j - 1]相同，此时不用增加元素，那么以下标i-2为结尾的word1 与 j-2为结尾的word2的最近编辑距离 加上一个替换元素的操作。
         */
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                }
            }
        }
        return dp[n][m];

    }

    public int minDistanceDP(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        //dp数组含义为 dp[i][j] 为word1以i为下标结尾的字符串和word2以j为下标结尾的字符串转换需要的最少次数
        //因为要考虑边界0的情况所以这里dp[0][0]代表两边都无字符串的情况，所以正在开始是从1开始这里的dp数组大小也就为n+1 m+1
        int[][] dp = new int[n+1][m+1];

        //初始化 对于第i个字符结尾的word1 第0个字符结尾的word2  word1需要删除i个字符才能转换为word2
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; //如果字符串相等继续沿用之前的 dp[i-1][j-1] 根据dp数组含义可知 dp[i-1][j-1] 就是word1 0~i-1 与 word2 0~j-1 转化所需的最少次数了
                }else{
                    //递推
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    //插入
                    //删除
                    //替换
                }
            }
        }

        return dp[n][m];
    }
}
