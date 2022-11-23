package com.jirafa.leetcode.algorithm.greedy;

/**
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class L53 {
    public int maxSubArray(int[] nums) {
        int count=0;
        int result=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count+=nums[i];
            result=Math.max(result,count);
            if(count<0)
                count=0;
        }

        return result;
    }

    public static void main(String[] args) {
        int i = new L53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}
