package com.feng.leetcode.hot100._00其他;


import java.util.Arrays;

public class QuickSortTemp {


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        quicksort(nums, 0, nums.length - 1);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public static void quicksort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partitionForJava(nums, left, right);
            quicksort(nums, index + 1, right);
            quicksort(nums, left, index - 1);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            // 从后往前找，直到找到一个比pivot更小的数
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            nums[i] = nums[j]; // 此时j已经表示前半部分了。
            // 从前往后找，直到找到一个比pivot更大的数
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i]; // 此时i已经表示后半部分了
        }
        nums[i] = pivot;
        return i;
    }

    public static int partitionForJava(int[] nums, int left, int right) {
        // 典型Java交换式partition
        int pivot = nums[right];
        int i = left; // i用于记录pivot该待的位置
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }




}
