package top.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-21-19:33
 */
@SuppressWarnings("all")
public class L1035不相交的线 {
    public static void main(String[] args) {

    }

    /**
     * 直线不能相交，这就是说明在字符串A中 找到一个与字符串B相同的子序列
     *
     * 本题说是求绘制的最大连线数，其实就是求两个字符串的最长公共子序列的长度！
     *
     * 既然是求两个字符串的最长公共子序列那么就可以参考 L1143最长公共子序列
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums2.length;
        int n = nums1.length;

        int[][] dp= new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
