package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-06-29-11:36
 * <p>
 * 给你一个整数数组 nums，和一个整数 k 。
 * <p>
 * 在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。
 * 将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
 * <p>
 * nums的分数是nums中最大和最小元素的差值。
 * <p>
 * 在对 nums 中的每个索引最多应用一次上述操作后，返回nums 的最低 分数 。
 */
@SuppressWarnings("all")
public class L908最小差值I {
    public static void main(String[] args) {
        System.out.println(new L908最小差值I().smallestRangeI(new int[]{1, 3, 6}, 3));
    }

    /**
     * 找规律 数学知识  由题目的规律可知找到数组中的最大值和最小值 判断他们的差值如果大于2k 那么直接差值-2k就是答案
     * 如果小于2k那么基本就是可通过这个[-k,k]之间的某个值将最大值和最小值变为同一个数
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int difference = max - min;

        if (difference > 2 * k) {
            return difference - 2 * k;
        } else {
            return 0;
        }
    }
}
