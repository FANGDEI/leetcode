package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-27-13:28
 */
@SuppressWarnings("all")
public class BM19寻找峰值 {
    public static void main(String[] args) {
        System.out.println(new BM19寻找峰值().findPeakElement(new int[]{2, 4, 1, 2, 7, 8, 4}));
    }

    public int findPeakElement (int[] nums) {
        int left = 0;
        int right = nums.length-1;

        /**
         * 按照题意我们只需要找到一个波峰即可  利用波峰的性质使用二分查找不断逼近区间 直至找到
         */
        while (left<right){
            int mid = (right-left)/2+left;
            //右边往下 不一定有波峰 也可能自己就是波峰
            if (nums[mid]>nums[mid+1]){
                right = mid;
                //右边往上一定能找到波峰
            }else {
                left = mid+1;
            }
        }
        //结尾返回波峰所在的下标
        return right;
    }



}
