package com.dyw.leetcode.algorithm.dp;

import java.util.Arrays;

/**
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * @author Devil
 * @since 2022-11-04-12:52
 */
@SuppressWarnings("all")
public class L416分割等和子集 {

    public static void main(String[] args) {
        System.out.println(new L416分割等和子集().canPartition(new int[]{2,2,1,1}));
    }

    /**
     * 01 背包问题 要满足两个子集分别和相等 可以抽象为 往 sum/2 的背包里面装满。
     *
     * 背包的体积为sum / 2
     * 背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
     * 背包如果正好装满，说明找到了总和为 sum / 2 的子集。
     * 背包中每一个元素是不可重复放入。
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums==null||nums.length==0){
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }

        //总和为奇数不能平分 返回false
        if (sum%2!=0) return false;
        //背包容量 sum的二分之1
        int target = sum/2;
        int[] dp = new int[target+1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j>=nums[i]; j--){
                //物品的i重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }

        return dp[target] == target;
    }
}
