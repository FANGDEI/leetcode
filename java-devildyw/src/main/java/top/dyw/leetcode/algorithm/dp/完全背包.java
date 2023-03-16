package top.dyw.leetcode.algorithm.dp;

/**
 * 完全背包与01背包的区别在于每件商品都有无数件
 *
 * @author Devil
 * @since 2022-11-06-13:40
 */
@SuppressWarnings("all")
public class 完全背包 {

    /**
     * 问背包能背的物品最大价值是多少？
     * <p>
     * 01背包和完全背包唯一不同就是体现在遍历顺序上，所以本文就不去做动规五部曲了，我们直接针对遍历顺序经行分析！
     * <p>
     * 我们知道01背包内嵌的循环是从大到小遍历，为了保证每个物品仅被添加一次。
     * <p>
     * 而完全背包中的物品是可以被添加多次的，所以要从小到大去遍历 这样可以一件物品多次添加。
     *
     * 对于完全背包而言 物品与背包的遍历顺序交换与01背包一样是同样无所谓。
     * @param args
     */
    public static void main(String[] args) {

        int[] weight = {1,3,4}; //物品重量
        int[] value = {15,20,30}; //物品价值
        int bagWeight = 4; //背包最大容量

        int[] dp = new int[bagWeight+1];
        //遍历
        for (int i = 0; i < weight.length; i++) { //遍历物品
            for (int j = weight[i]; j<=bagWeight; j++){ //遍历背包容量
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }

        /**
         * 可以看到与01背包的区别就只有遍历顺序的不同。
         */
        for (int maxValue : dp) {
            System.out.print(maxValue+" ");
        }

    }


}
