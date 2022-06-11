package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L35搜索插入位置
 * @author: Ladidol
 * @description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * @date: 2022/5/16 15:03
 * @version: 1.0
 */
public class L35搜索插入位置 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        System.out.println(new L35().searchInsert(nums, 7));
    }
}
class L35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left <= right){
            mid = (right - left) / 2 + left;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid] < target){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }
        return left;//都可以的
//        return right+1;
    }
}
