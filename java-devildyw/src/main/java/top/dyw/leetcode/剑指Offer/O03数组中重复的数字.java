package top.dyw.leetcode.剑指Offer;

import java.util.Arrays;

/**
 * @author Devil
 * @since 2023-02-28-11:15
 */
@SuppressWarnings("all")
public class O03数组中重复的数字 {
    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }

    public int findRepeatNumber01(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]==nums[i]){
                return nums[i];
            }
        }
        return -1;
    }
}
