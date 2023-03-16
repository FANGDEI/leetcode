package top.dyw.leetcode.algorithm.dp;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * @author Devil
 * @since 2022-10-29-15:41
 */
@SuppressWarnings("all")
public class L509斐波那契数 {

    public static void main(String[] args) {
        System.out.println(new L509斐波那契数().fib(4));
    }

    /**
     * 1. 确定 dp数组 以及下标的含义： dp数组的定义为：第i个数的斐波那契数值是 dp[i]
     *
     * 2. 确定递推公式: dp[i] = dp[i-1]+dp[i-2]
     *
     * 3. dp 数组如何初始化： 题目已知 dp[0] = 0, dp[1] = 1
     *
     * 4. 确定遍历顺序： 从前往后推到 所以遍历也是从前到后遍历的
     *
     * 5. 举例推导 dp 数组
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n<=1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
