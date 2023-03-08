package com.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2023-03-03-15:52
 */
@SuppressWarnings("all")
public class O53II0n_1中缺失的数字 {

    public static void main(String[] args) {

    }

    /**
     * 二分法
     * @param nums 数组是有序递增的 并且在target之前 i = nums[i]
     * @return
     */
    public int missingNumber(int[] nums) {
        int res = -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high-low)/2 + low;
            if (mid == nums[mid]){
                low = mid +1;
            }else {
                res = mid;
                high = mid -1;
            }
        }
        return res == -1?nums.length:res;

    }
}
