package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-03-20:12
 */


@SuppressWarnings("all")
public class 一维dp数组01背包 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4}; //物品重量
        int[] value = {15, 20, 30}; //物品价值
        int bagsize = 4; //背包容量

        testweightbagproblem(weight, value, bagsize);
    }

    /**
     * 一维dp数组01背包 就是在二维dp数组上进行了压缩dp[i][j](一维数组，也可以理解为是一个滚动数组   需要满足的一个条件是 上一层可以重复利用)。
     * 1. 确定dp数组的定义: 在一维数组中 dp[j] 表示：容量为j的背包，所背的物品价值最大可用为 dp[j]
     * <p>
     * 2. 递推公式： dp[j] 可以通过dp[j-weight[i]] 推导出来，dp[j-weight[i]] 表示容量为j-weight[i] 的背包所背的最大价值。 dp[j-weight[i]]+value[i] 表示容量为 j-物品i重量的背包加上物品的i价值。[也就是容量为j的背包，放入了物品i之后的价值即dp[j]]
     * dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
     * <p>
     * 3.dp数组的初始化，dp数组在推导的时候一定是取价值最大的数，如果题目给的价值都是正整数那么非0下标都初始化为0就可以了。
     * <p>
     * 4.遍历顺序 背包容量是从大到小的，这样的目的是为了保证物品i只被放入 一次！
     *
     * @param weight
     * @param value
     * @param bagsize
     */
    private static void testweightbagproblem(int[] weight, int[] value, int bagsize) {
        int wlen = weight.length;
        int[] dp = new int[bagsize + 1];

        for (int i = 0; i < wlen; i++) {
            for (int j = bagsize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        //打印数组
        for (int i = 0; i < bagsize + 1; i++) {
            System.out.print(dp[i] + " ");
        }
    }

}
