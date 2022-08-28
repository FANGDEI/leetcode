package com.dyw.leetcode.algorithm.binarySearch.template;

/**
 * @author Devil
 * @since 2022-08-28-10:11
 */
public class First {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new First().binarySearch(ints, 6));
    }

    /**
     * 区间左闭右闭型
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length-1;

        //因为left = right 是有意义的 因为最坏情况也是left = right = nums.length-1
        while (left<=right){
            //这种取中间值的方法可以防止溢出
            int mid = left + (right - left)/2;
            //左闭右闭 当前可知右区间一定不会有target目标值 所以去左区间查找 所以这个赋值right = mid -1
            if (nums[mid]>target){
                right = mid - 1;
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
