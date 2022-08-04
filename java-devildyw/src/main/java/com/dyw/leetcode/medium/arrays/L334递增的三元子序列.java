package com.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-07-29-11:43
 * <p>
 * 给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 如果存在这样的三元组下标 (i, j, k)且满足 i < j < k ，使得nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 */
@SuppressWarnings("all")
public class L334递增的三元子序列 {
    public static void main(String[] args) {
        int[] ints = {2,1,5,0,4,6};
        System.out.println(new L334递增的三元子序列().increasingTriplet(ints));
    }

    /**
     * 贪心 只要找到三个递增顺序的数即可
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n<3){
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            //再更新second的值之前是没有数可以超过second的
            //如果有一个数超过了second 说明已经 first < second < num 符合题意
            if (num>second){
                return true;
            //如果一个数大于了first 那么这个数就利索当然成为了second
            }else if (num>first){
                second = num;
            }else{ //first则是减别人剩下的 更新first 这个first只可能比原来的first小或者等于 需要保证first比其他两个值小
                first = num;
            }
        }
        return false;
    }
}
