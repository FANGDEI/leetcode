package top.dyw.leetcode.Hot100;

public class L153寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        // 避免死循环 当left == right 是 会死循环
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]){
                // mid 可能就是最小值
                right = mid;
            }
        }
        return nums[left];
    }
}
