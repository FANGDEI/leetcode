package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-02-15:09
 */
@SuppressWarnings("all")
public class 二维dp数组01背包 {

    public static void main(String[] args) {
        int[] weight = {1,3,4}; //物品重量
        int[] value = {15,20,30}; //物品价值
        int bagsize = 4; //背包容量

        testweightbagproblem(weight,value,bagsize);
    }

    /**
     * 1. 确定dp数组以及下标的含义： 对于背包问题其中一种写法是使用二维数组 dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为 j 的背包，价值总和最大是多少；
     *
     * <img src="https://img-blog.csdnimg.cn/20210110103003361.png">
     * <p>
     * 2. 确定递推公式，可由两个方向推导处 dp[i][j]
     * <p>
     * I. 不放物品i: 当物品i的重量大于背包j剩余能装载的最大重量时，物品无法放入背包中，所以背包内的价值依然和前面的相同
     * <p>
     * II. 放物品i: 由 dp[i-1][j-weight[i]] 推出，dp[i-1][j-weight[i]] 就是背包容量为j-weight[i]的时候不放物品i的最大价值,那么dp[i-1][j-weight[i]]+value[i] 就是背包放物品i的最大价值。
     * <p>
     * 所以递推公式: dp[i][j] = max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
     * <p>
     * 3. dp数组初始化 对于所有物品 当背包容量j为0的话，即 dp[i][0] ，无论什么选取那些物品，背包价值一定为0 除此之外还要初始化i=0 因为dp[i][j]都是由 i-1 推导出来的
     * dp[0][j] 存放物品0的时候，各个容量背包所能存放的最大价值。 其他因为在遍历途中会被覆盖所以初始化为0就可以了（java 数组默认值为0）
     * <p>
     * 4. 遍历顺序先遍历物品再遍历重量， 遍历物品更符合上述的分析描述（该物品遍历各个容量的背包以更新背包所能装载的最大价值）
     *
     * 5. 举例dp数组
     *
     * <img src="https://img-blog.csdnimg.cn/20210118163425129.jpg">
     *
     * @param weight
     * @param value
     * @param bagsize
     */
    public static void testweightbagproblem(int[] weight, int[] value, int bagsize) {
        int wlen = weight.length;
        //定义dp数组 dp[i][j] 表示 背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen+1][bagsize+1];
        //初始化：背包容量为0时，能获得的价值为0
        for (int i = 0; i < wlen; i++) {
            dp[i][0] = 0;
        }

        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wlen; i++) {
            for (int j = 1; j <= bagsize; j++) {
                //如果j的容量放不下weight[i-1] 就取上一个j容量能容纳0~i-1中物品的最大价值 dp[i-1][j]
                if (j<weight[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }

        //打印 dp 数组
        for (int i = 0; i<=wlen; i++){
            for (int j = 0; j<=bagsize; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void testweightbagproblem01(int[] weight, int[] value, int bagsize) {
        int wlen  = weight.length;

        int[][] dp = new int[wlen + 1][bagsize + 1];

        //初始化dp数组
        for (int i = 0; i <= wlen; i++) {
            dp[i][0] = 0;
        }

        //遍历
        for (int i = 1; i <= wlen; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (weight[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }

        for (int i = 0; i < wlen + 1; i++) {
            for (int j = 0; j < bagsize + 1; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
