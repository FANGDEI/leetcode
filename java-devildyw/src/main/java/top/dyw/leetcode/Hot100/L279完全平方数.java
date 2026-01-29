package top.dyw.leetcode.Hot100;
import java.util.*;
public class L279完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];

        for (int i=1; i<=n; i++) {
            dp[i] = i;

            for (int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
