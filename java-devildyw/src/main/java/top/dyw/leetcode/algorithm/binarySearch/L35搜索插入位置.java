package top.dyw.leetcode.algorithm.binarySearch;

/**
 * @author Devil
 * @since 2022-07-11-10:03
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
@SuppressWarnings("all")
public class L35搜索插入位置 {
    public static void main(String[] args) {
        System.out.println(new L35搜索插入位置().searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //这一步是关键 用于省时间
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
