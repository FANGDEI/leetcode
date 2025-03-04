package top.dyw.leetcode.simple.arrays;

import java.util.Arrays;

/**
 * @author Devil
 * @since 2022-07-12-10:11
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
@SuppressWarnings("all")
public class L977有序数组的平方 {
    public static void main(String[] args) {
        int[] ints = new L977有序数组的平方().sortedSquares03(new int[]{-4, -1, 0, 3, 10});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    /**
     * 一般做法,先平方再排序
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 双指针,我们要知道当两个正数的大小关系在平方后不会改变 又因为数组事非递增有事从负数开始 中间的往往平方后都是最小的 两边平方后都是两边大中间小 根据这种关系进行排序 根据这种关系依次按照两边同时比较 将平方大的数放在新数组的后面
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares01(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = right;
        while (left <= right) {
            if (-nums[left] > nums[right]) {
                res[i] = nums[left] * nums[left];
                left += 1;
            } else {
                res[i] = nums[right] * nums[right];
                right -= 1;
            }
            i--;
        }
        return res;
    }

    /**
     * 代码随想录双指针法
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares02(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = result.length-1;
        while (left<=right){
            if (nums[left]*nums[left]<nums[right]*nums[right]){
                result[index--] = nums[right]*nums[right];
                right--;
            }else{
                result[index--] = nums[left]*nums[left];
                left++;
            }
        }
        return result;
    }

    public int[] sortedSquares03(int[] nums) {
        // 双指针
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right){
            if (nums[left]*nums[left] >= nums[right] * nums[right]){
                result[index--] = nums[left]*nums[left];
                left++;
            }else {
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

}
