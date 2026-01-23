package top.dyw.leetcode.Hot100;

public class L34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        // 先查找第一个位置
        int left = 0;
        int right = nums.length - 1;

        int first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid+1;
            } else {
                if (nums[mid] == target) {
                    first = mid;
                }
                right = mid - 1;
            }
        }

        int second = -1;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    second = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{first, second};
    }
}
