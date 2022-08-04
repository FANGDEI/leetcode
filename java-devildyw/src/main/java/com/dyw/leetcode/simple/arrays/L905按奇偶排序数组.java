package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-06-28-11:33
 * <p>
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * <p>
 * 返回满足此条件的 任一数组 作为答案。
 */
@SuppressWarnings("all")
public class L905按奇偶排序数组 {
    public static void main(String[] args) {
        int[] ints = new L905按奇偶排序数组().sortArrayByParity(new int[]{0});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    /**
     * 一次遍历 + 双指针
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] ints = new int[n];
        int left = 0, right = n - 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                ints[left++] = nums[i];
            } else {
                ints[right--] = nums[i];
            }
        }

        return ints;
    }

    /**
     * 原地交换
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParity01(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            //遍历左半边数组 找到下一个为奇数的元素的下标
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            //遍历右半边数组 找到下一个为偶数的元素的下标
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            //如果满足left<right就将两者进行交换 (奇偶交换)
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                //交换后一定要下标进行偏移 否者会发生死循环
                left++;
                right--;
            }
        }
        return nums;
    }
}
