package top.dyw.leetcode.algorithm.dp;

/**
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *
 * @author Devil
 * @since 2022-11-05-12:09
 */
@SuppressWarnings("all")
public class L474一和零 {

    public static void main(String[] args) {

    }

    /**
     * 动态规划 01背包问题（是两个维度上的） //todo: 后面多过几遍
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示 i个 0和j个1时的最大子集
        //两个维度 0 和 1
        int[][] dp = new int[m+1][n+1];
        int oneNum ,zeroNum ;
        //遍历每个字符串
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            //找出每个字符串所带有的0和1
            for (char c : str.toCharArray()) {
                if (c=='0'){
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }
            //倒序遍历 两个维度更新 状态转移方程更新 dp[i-zeroNum][j-oneNum] 代表 带有i-zeroNum个0 j-oneNum个1的最大子集 + 1 代表将当前符合条件的字符串（带有 zeroNum个0,oneNum个1）加入集合中
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }
        return dp[m][n];

    }
}
