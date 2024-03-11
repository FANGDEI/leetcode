package com.feng.leetcode.offerII._11二分查找;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/28 18:02
 * @description: {}
 */
public class QuickSort {


    void quickSort(int l, int r, int[] nums) {
        if (l >= r) {
            return;
        }

        int p = partition(l, r, nums);
        quickSort(l, p - 1, nums);
        quickSort(p + 1, r, nums);

    }

    int partition(int l, int r, int[] nums) {

        int p = nums[l];
        int left = l, right = r;

        while (left < right) {
            while (left < r && nums[left] < p) {
                left++;
            }
            while (right >= l && nums[right] >= p) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(left, right, nums);
            left++;
            right--;
        }
        swap(l, left, nums)
        return left;
    }

    void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
