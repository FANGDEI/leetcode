package com.dyw.leetcode.algorithm.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-09-01-20:02
 * <p>
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * <p>
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * <p>
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 */
@SuppressWarnings("all")
public class L904水果成篮 {
    public static void main(String[] args) {
        System.out.println(new L904水果成篮().totalFruit(new int[]{0,1, 2, 1}));
    }

    /**
     * 滑动窗口 找出最大只有两种水果的最长子序列
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        //结果
        int ans = 0;
        //hash表记录种类 以及数量
        HashMap<Integer,Integer> hash = new HashMap<>();
        //窗口左边界
        int left = 0;
        //滑动
        for (int right = 0; right<fruits.length; right++){
            //窗口右移
            hash.put(fruits[right],hash.getOrDefault(fruits[right],0)+1);
            //如果种类 使得种类数量始终控制在 3个以下
            while (hash.size()>=3){
                //超过/等于三个时 窗口左移 目的控制种类数量为3个以下
                hash.put(fruits[left],hash.getOrDefault(fruits[left],0)-1);
                if (hash.getOrDefault(fruits[left],0)==0){
                    hash.remove(fruits[left]);
                }
                //左移
                left++;
            }

            //更新数据
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
