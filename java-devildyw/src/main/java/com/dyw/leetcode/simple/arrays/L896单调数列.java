package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-06-27-22:39
 * <p>
 * 如果数组是单调递增或单调递减的，那么它是单调 的。
 * <p>
 * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums是单调递减的。
 * <p>
 * 当给定的数组 nums是单调数组时返回 true，否则返回 false。
 */
@SuppressWarnings("all")
public class L896单调数列 {
    public static void main(String[] args) {
        System.out.println(new L896单调数列().isMonotonic(new int[]{6,5,4,4}));
    }

    public boolean isMonotonic(int[] nums) {
        if (nums.length==1){
            return true;
        }

        int flag = 0;


        for (int i = 0; i < nums.length; i++) {
            if (i+1< nums.length&&nums[i]>nums[i+1]){
                flag = 1;
                break;
            }
        }

        if (flag==1){
            for (int i = 0; i < nums.length; i++) {
                if (i+1< nums.length&&nums[i]<nums[i+1]){
                    flag = 2;
                    break;
                }
            }
        }
        return (flag==0)||(flag==1);
    }

}
