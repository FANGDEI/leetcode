package top.dyw.leetcode.Hot100;

public class L33搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 找到有序的区间在进行二分
            if (nums[mid] >= nums[left]) {
                // 发现 target 在这个区间内 收缩区间
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }  else {
                    left = mid + 1;
                }
            } else {
                // 同理
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
