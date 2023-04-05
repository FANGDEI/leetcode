package top.dyw.leetcode.algorithm.dp;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 * @author Devil
 * @since 2022-10-30-14:27
 */
@SuppressWarnings("all")
public class L746使用最小花费爬楼梯 {

    public static void main(String[] args) {

    }

    /**
     * 1. dp[i] 代表 到达第i个台阶所花费得最小体力(这里认为是第一步是一定要花费得)
     * <p>
     * 2. 递推公式: dp[i] = min(dp[i-1],dp[i-2]) + cost[i]; 后两阶中最小值加上当前值的花费就是到达第i个台阶的最小花费
     * <p>
     * 3. 初始化：dp[0] = cost[0] dp[1] =cost[1]
     * <p>
     * 4. 从前往后遍历 cost数组
     * <p>
     * 5. <img src = "https://img-blog.csdnimg.cn/2021010621363669.png">
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];

        //计算到达每一层台阶得最小费用
        for (int i = 2; i < cost.length; i++) {
            //因为一次可以根据价格选择 跨一阶或者两阶 所以当前层的 最小花费 可以由下两层之间的最小值再加上当前层的花费即可得到。 递推到最后可以得到到达顶端的最小值
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        //最后一步，如果是由倒数第二步爬，则最后一步的体力花费可以不用算
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}
