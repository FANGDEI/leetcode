package com.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-07-29-12:42
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 */
@SuppressWarnings("all")
public class L560和为K的子数组 {
    public static void main(String[] args) {

    }

    /**
     * 因为要寻找连续的子数组 所以我们使用双循环遍历即可找到
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >=0; --end){
                sum += nums[end];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }


    //todo: hash表+前缀和
}
