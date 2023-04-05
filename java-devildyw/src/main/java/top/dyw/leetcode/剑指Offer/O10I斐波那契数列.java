package top.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2023-03-01-11:18
 */
@SuppressWarnings("all")
public class O10I斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(new O10I斐波那契数列().fib(48));
    }

    /**
     * 简单动态规划
     * 地推公式 dp[i]=dp[i-1]+dp[i-2]
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n < 2) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];

    }



    public int fib01(int n) {
        if (n<2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }

        return dp[n];
    }
}
