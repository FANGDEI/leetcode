package com.feng.draft.template.经典排序;

public class BinarySearch {
    public static int findFirstGreaterOrEqual(int[] nums, int target) {


        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1; // 继续在左半部分查找
            } else {
                left = mid + 1; // 在右半部分查找
            }
        }

        return result + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4, 5};
        int target = 0;

        int index = findFirstGreaterOrEqual(nums, target);
        if (index != -1) {
            System.out.println("第一个大于等于目标值的位置为：" + index);
        } else {
            System.out.println("数组中不存在大于等于目标值的元素");
        }
    }
}