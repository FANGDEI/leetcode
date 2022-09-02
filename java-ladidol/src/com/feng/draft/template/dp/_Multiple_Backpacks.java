package com.feng.draft.template.dp;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.draft.template.dp
 * @className: _Multiple_Backpacks
 * @author: Ladidol
 * @description:
 * @date: 2022/9/1 22:35
 * @version: 1.0
 */
public class _Multiple_Backpacks {
    public static void main(String[] args) {
        testMultiPack1();
    }

    // 把多重背包展开————看成特殊的01背包：
    public static void testMultiPack1() {
        // 版本一：改变物品数量为01背包格式
        List<Integer> weight = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> value = new ArrayList<>(Arrays.asList(15, 20, 30));
        List<Integer> count = new ArrayList<>(Arrays.asList(2, 3, 2));
        int bagWeight = 10;

        for (int i = 0; i < count.size(); i++) {
            while (count.get(i) > 1) { // 把物品展开为i
                weight.add(weight.get(i));
                value.add(value.get(i));
                count.set(i, count.get(i) - 1);// 维护count
            }
        }

        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.size(); i++) { // 遍历物品
            for (int j = bagWeight; j >= weight.get(i); j--) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
            }
            System.out.println(Arrays.toString(dp));
        }
    }

    // 类似于完全背包个数有限版本：毕竟「完全背包」不限制物品数量，「多重背包」限制物品数量。
    public void testMultiPack2(){
        // 版本二：改变遍历个数
        int[] weight = new int[] {1, 3, 4};
        int[] value = new int[] {15, 20, 30};
        int[] count = new int[] {2, 3, 2};
        int bagWeight = 10;

        int[] dp = new int[bagWeight + 1];
        for(int i = 0; i < weight.length; i++) { // 遍历物品
            for(int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
                // 以上为01背包，然后加一个遍历个数
                for (int k = 1; k <= count[i] && (j - k * weight[i]) >= 0; k++) { // 遍历个数
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
                System.out.println(Arrays.toString(dp));
            }
        }
    }




}
