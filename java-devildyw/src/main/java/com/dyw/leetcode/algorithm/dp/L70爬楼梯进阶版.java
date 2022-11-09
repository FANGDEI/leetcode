package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-09-10:43
 */
@SuppressWarnings("all")
public class L70爬楼梯进阶版 {

    public static void main(String[] args) {
        System.out.println(new L70爬楼梯进阶版().climbStairs(3));
    }

    /**
     * 完全背包解法
     *
     * 背包容量为 n（楼梯共有n阶），物品有 1 和 2（一次能上1个或两个台阶） 试问装满背包共有多少种方法
     *
     * dp[i] 表示 装满容量为 i 的背包最多有 dp[i] 中方法，我们有又可以知道 dp[i]是由 dp[i-j] 推导得到 (j = 1 ,2)
     *
     * 递推公式就为 dp[i] += dp[i-j] 计算方法 这里的方法 1，2 和 2，1 是两种方法 所以这里求得方法数其实是排列数
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        /**
         * 初始化dp数组
         */
        int[] dp = new int[n+1];
        dp[0] = 1; //上0阶楼梯的方法只有一种 那就是一阶都不上

        //计算排列数 那么就要先遍历背包 这样使得一个容量的背包可以遍历所有一次能上的楼梯阶数 就可以得到不同的排列
        for (int i = 1; i <= n; i++) {
            //一次最多爬2阶楼梯
            for (int j = 1; j <= 2; j++) { //其实还是长得像斐波那契数列
                if (i>=j){
                    dp[i]+=dp[i-j];
                }
            }
        }
        return dp[n];
    }
}
