package com.dyw.leetcode.medium.priority_queue;

/**
 * @author Devil
 * @since 2022-08-18-17:53
 * <p>
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
@SuppressWarnings("all")
public class L215数组中的第K个最大元素 {
    public static void main(String[] args) {
        System.out.println(new L215数组中的第K个最大元素().findKthLargest(new int[]{72, 6, 57, 88, 60, 42, 83, 73, 48, 85}, 7));
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        quick_sort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num+" ");
        }
        return nums[nums.length-k];
    }

    private void quick_sort(int[] nums, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = nums[l];
            while (i < j) {
                while (i < j && nums[j] >= x){
                    j--;
                }
                if (i<j){
                    nums[i++] = nums[j];
                }

                while (i<j&&nums[i]<x){
                    i++;
                }
                if (i<j){
                    nums[j--] = nums[i];
                }
            }
            nums[i] = x;
            quick_sort(nums,l,i-1);
            quick_sort(nums,i+1,r);

        }
    }

    //todo: 大小堆
}
