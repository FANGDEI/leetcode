package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-04-13:14
 */
@SuppressWarnings("all")
public class L1049最后一块石头的重量II {

    public static void main(String[] args) {

    }

    /**
     * 本题可以抽象为背包问题 本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了。(要求获得最小可能重量)
     *
     * 石头的重量为 stone[i] 物品的价值也为 stone[i]
     *
     * 要求尽量让石头分成重量相同的两堆 所以这里背包容量 j 为target的一半
     *
     * 通过状态转移方程 得到dp[target] 里就是容量为 target 的背包所能背的最大重量了。
     *
     * 注意：在计算target的时候，target = sum / 2 因为是向下取整，所以sum - dp[target] 一定是大于等于dp[target]的。
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum+=stone;
        }
        int target = sum>>1; //除以2 向下取整

        //初始化 dp 数组
        int[] dp = new int[target+1];

        for (int i = 0; i < stones.length; i++) {
            //倒序
            for (int j = target; j>=stones[i];j++){
                dp[j] =Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }

        return (sum-dp[target])-dp[target];
    }
}
