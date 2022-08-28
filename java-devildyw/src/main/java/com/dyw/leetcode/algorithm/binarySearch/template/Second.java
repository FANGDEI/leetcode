package com.dyw.leetcode.algorithm.binarySearch.template;

/**
 * @author Devil
 * @since 2022-08-28-10:18
 */
public class Second {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new Second().binarySearch(ints, 6));
    }

    /**
     * 区间左闭右开型
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length;

        //因为left = right 是无意义的 因为最坏情况是left = right = nums.length 数组越界无意义
        while (left<right){
            //这种取中间值的方法可以防止溢出
            int mid = left + (right - left)/2;
            //左闭右闭 当前可知右区间一定不会有target目标值 又因为为开区间 所以right = mid 刚好与left将左区间包囊完整
            if (nums[mid]>target){
                right = mid;
            }//左区间同理
            else if (nums[mid]<target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
