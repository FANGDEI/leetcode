package com.feng.newline.dp.backage;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L474一和零
 * @author: Ladidol
 * @description: 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 * <p>
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * @date: 2022/8/18 20:16 2022年8月30日18:12:55
 * @version: 1.0
 */
public class L474一和零 {
    //三维数组
    class Solution1 {
        //f[k][i][j]=max(f[k−1][i][j],f[k−1][i−cnt[k][0]][j−cnt[k][1]]+1)
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] cnt = new int[strs.length][2];//计数0和1的个数
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                for (char c : chars) {
                    if (c == '1') cnt[i][1]++;
                    else cnt[i][0]++;
                }
            }
            int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
            //这里就不初始化了，直接用带有双0边界的dp数组。dp[0][i][j]=0初始化意义为：无字符串的话dp就为零。
            for (int k = 1; k <= strs.length; k++) {
                int zeroNum = cnt[k - 1][0], oneNum = cnt[k - 1][1];
                for (int i = 0; i <= m; i++) {//零背包
                    for (int j = 0; j <= n; j++) {//一背包
                        int no = dp[k - 1][i][j];//不考虑第k个str；
                        int yes = (zeroNum <= i && oneNum <= j) ? dp[k - 1][i - zeroNum][j - oneNum] + 1 : 0;//考虑
                        dp[k][i][j] = Math.max(no, yes);
                    }
                }
            }
            return dp[strs.length][m][n];
        }
    }

    // 滚动数组优化
    class Solution2 {
        //f[k][i][j]=max(f[k−1][i][j],f[k−1][i−cnt[k][0]][j−cnt[k][1]]+1)
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] cnt = new int[strs.length][2];//计数0和1的个数
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                for (char c : chars) {
                    if (c == '1') cnt[i][1]++;
                    else cnt[i][0]++;
                }
            }
            int[][][] dp = new int[2][m + 1][n + 1];
            //这里就不初始化了，直接用带有双0边界的dp数组。dp[0][i][j]=0初始化意义为：无字符串的话dp就为零。
            for (int k = 1; k <= strs.length; k++) {
                int zeroNum = cnt[k - 1][0], oneNum = cnt[k - 1][1];
                for (int i = 0; i <= m; i++) {//零背包
                    for (int j = 0; j <= n; j++) {//一背包
                        int no = dp[(k - 1) & 1][i][j];//不考虑第k个str；
                        int yes = (zeroNum <= i && oneNum <= j) ? dp[(k - 1) & 1][i - zeroNum][j - oneNum] + 1 : 0;//考虑
                        dp[k & 1][i][j] = Math.max(no, yes);
                    }
                }
            }
            return dp[strs.length & 1][m][n];
        }
    }

    // 二维数组（类模板题中的降维法）
    class Solution {
        //f[k][i][j]=max(f[k−1][i][j],f[k−1][i−cnt[k][0]][j−cnt[k][1]]+1)
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] cnt = new int[strs.length][2];//计数0和1的个数
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                for (char c : chars) {
                    if (c == '1') cnt[i][1]++;
                    else cnt[i][0]++;
                }
            }
            int[][] dp = new int[m + 1][n + 1];
            //这里就不初始化了，直接用带有双0边界的dp数组。dp[0][i][j]=0初始化意义为：无字符串的话dp就为零。
            for (int k = 1; k <= strs.length; k++) {
                int zeroNum = cnt[k - 1][0], oneNum = cnt[k - 1][1];
                for (int i = m; i >= 0; i--) {//零背包
                    for (int j = n; j >= 0; j--) {//一背包
                        int no = dp[i][j];
                        int yes = (zeroNum <= i && oneNum <= j) ? dp[i - zeroNum][j - oneNum] + 1 : 0;
                        dp[i][j] = Math.max(no, yes);
                    }
                }
            }
            return dp[m][n];
        }
    }

}
