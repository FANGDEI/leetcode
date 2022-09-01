package com.feng.newline.dp.backage;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L1049最后一块石头的重量II
 * @author: Ladidol
 * @description: 有一堆石头，用整数数组stones 表示。其中stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * <p>
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * @date: 2022/8/17 23:03
 * @version: 1.0
 */
public class L1049最后一块石头的重量II {
    //01背包问题化：
    //本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了。
    //像上面那样想的话，就和416很像了。
    //本题物品的重量为stones[i]，物品的价值也为stones[i]。
    //对应着01背包里的物品重量weight[i]和 物品价值value[i]。


    //1. 确定dp数组以及下标的含义：dp[j]表示容量为j的背包，最多可以背dp[j]这么重的石头。
    //2. 确定递推公式：dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
    //3. dp数组如何初始化：dp[i] = 0;
    //4. 确定遍历顺序：01背包一维dp滚动数组
    //5. 举例推导dp数组：


    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = Arrays.stream(stones).sum();
//            if (sum%2==0) return
            int[] dp = new int[sum / 2 + 1];
            for (int i = 0; i < stones.length; i++) {
                for (int j = sum / 2; j >= stones[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
            return sum - 2 * dp[sum / 2];
        }
    }


    //二维dp，emm看一下。
    class Solution2 {
        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for (int s : stones) {
                sum += s;
            }

            int target = sum / 2;
            //初始化，dp[i][j]为可以放0-i物品，背包容量为j的情况下背包中的最大价值
            int[][] dp = new int[stones.length][target + 1];
            //dp[i][0]默认初始化为0
            //dp[0][j]取决于stones[0]
            for (int j = stones[0]; j <= target; j++) {
                dp[0][j] = stones[0];
            }

            for (int i = 1; i < stones.length; i++) {
                for (int j = 1; j <= target; j++) {//注意是等于
                    if (j >= stones[i]) {
                        //不放:dp[i - 1][j] 放:dp[i - 1][j - stones[i]] + stones[i]
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return (sum - dp[stones.length - 1][target]) - dp[stones.length - 1][target];
        }
    }

    //滚动数组优化，二维数组
    class Solution3 {
        public int lastStoneWeightII(int[] stones) {
            int sum = Arrays.stream(stones).sum();
            int target = sum / 2;
            int[][] dp = new int[2][target + 1];
            for (int j = stones[0]; j <= target; j++) {
                dp[0][j] = stones[0];
            }

            for (int i = 1; i < stones.length; i++) {
                for (int j = 1; j <= target; j++) {//注意是等于
                    if (j >= stones[i]) {
                        dp[i & 1][j] = Math.max(dp[(i - 1) & 1][j], dp[(i - 1) & 1][j - stones[i]] + stones[i]);
                    } else {
                        dp[i & 1][j] = dp[(i - 1) & 1][j];
                    }
                }
            }

            return (sum - dp[(stones.length - 1) & 1][target] * 2);
        }
    }

}
