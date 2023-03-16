package top.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-22-12:43
 */
@SuppressWarnings("all")
public class L115不同的子序列 {
    public static void main(String[] args) {
        System.out.println(new L115不同的子序列().numDistinct("babgbag", "bag"));
    }

    /**
     * 根据题意要求找到s中t出现的个数 即找到从s不改变相对位置中能得到t的的方案数量
     * 解释：现在s中能够找到t的所有字符，中间如果找到了重复的字符就有着不同的方式（因为换一个索引的字符也算是一个新的方式） 即 rabbbit 与 rabbit 就有三种不同的方案
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        /**
         * dp[i][j]: s以i-1结尾的字符串出现t以j-1结尾的字符串的个数为dp[i][j]
         */
        int[][] dp = new int[n + 1][m + 1];

        //初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        /**
         * 这一类问题，基本是要分析两种情况
         *
         * s[i - 1] 与 t[j - 1]相等
         * s[i - 1] 与 t[j - 1] 不相等
         * 当s[i - 1] 与 t[j - 1]相等时，dp[i][j]可以有两部分组成。
         *
         * 一部分是用s[i - 1]来匹配，那么个数为dp[i - 1][j - 1]。
         *
         * 一部分是不用s[i - 1]来匹配，个数为dp[i - 1][j]。
         *
         * 这里可能有同学不明白了，为什么还要考虑 不用s[i - 1]来匹配，都相同了指定要匹配啊。
         *
         * 例如： s：bagg 和 t：bag ，s[3] 和 t[2]是相同的，但是字符串s也可以不用s[3]来匹配，即用s[0]s[1]s[2]组成的bag。
         *
         * 当然也可以用s[3]来匹配，即：s[0]s[1]s[3]组成的bag。
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //当有dp[i-1][j]为0时 dp[i-1][j-1] + dp[i-1][j] 代表寻找子序列的方案 但如果dp[i-1][j]不为0 则 dp[i-1][j-1] + dp[i-1][j] 代表多个方案相加
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    //dp[i-1][j]用来判断是否有相同的字符可以匹配的 这样就可以多一种方案了
                } else {
                    //如果不相等 就比较 s[i-2] 与 t[j-1]
                    dp[i][j] = dp[i - 1][j];
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][m];
    }
}
