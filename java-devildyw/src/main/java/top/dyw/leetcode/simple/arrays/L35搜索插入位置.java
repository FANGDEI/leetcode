package top.dyw.leetcode.simple.arrays;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/02/24 10:07
 **/
@SuppressWarnings("all")
public class L35搜索插入位置 {

    public static void main(String[] args) {
        System.out.println(new L35搜索插入位置().searchInsert(new int[]{1, 3}, 4));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (right + left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        //如果不存在相等的元素的话，right就会在小于target的最大元素哪个位置不动 left 收缩直至与right 相等，那么此时插入的位置就在right的下一个位置
        return right + 1;
    }
}
