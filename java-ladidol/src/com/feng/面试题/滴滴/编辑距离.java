package com.feng.面试题.滴滴;

/**
 * @author fengxiaoqiang
 */
public class 编辑距离 {

  public static void main(String[] args) {

    String strA = "abcde";
    String strB = "bcd";

    int ans = minDistance(strA, strB);
    System.out.println("ans = " + ans);
  }

  /**
   * 最小 相等 dp[i][j] = dp[i-1][j-1]
   * <p>
   * 不相等 dp[i][j] = 1+ dp[i-1][j-1]/dp[i-1][j]/dp[i][j-1]
   */
  private static int minDistance(String strA, String strB) {
    int m = strA.length();
    int n = strB.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j <= n; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (strA.charAt(i - 1) == strB.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
        }
      }
    }
    return dp[m][n];
  }

}
