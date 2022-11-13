package com.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-13-16:26
 */
@SuppressWarnings("all")
public class L53最大子数组和 {

    public int maxSubArray(int[] nums) {
         int ans = Integer.MIN_VALUE;
         int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum<=0){
                sum = nums[i];
            }else{
                sum+=nums[i];
            }
            ans = Math.max(sum,ans);

        }
        return ans;
    }



}
