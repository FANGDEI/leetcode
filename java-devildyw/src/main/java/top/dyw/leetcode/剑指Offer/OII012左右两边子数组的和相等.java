package top.dyw.leetcode.剑指Offer;

import java.util.Arrays;

/**
 * @author Devildyw
 * @date 2023/06/01 20:18
 **/
@SuppressWarnings("all")
public class OII012左右两边子数组的和相等 {
    public static void main(String[] args) {
        System.out.println(new OII012左右两边子数组的和相等().pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    /**
     * 前缀和 符合题意
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2*sum+nums[i]==total){
                return i;
            }
            sum+=nums[i];
        }
        return -1;
    }

}
