package com.dyw.leetcode.simple;

import java.util.Arrays;

/**
 * @author Devil
 * @date 2022-05-19-17:04
 *
 * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大。
 *
 * 返回该 最大总和 。
 */
@SuppressWarnings("all")
public class L561数组拆分I {
    public static void main(String[] args) {

    }

    /**
     * 我们每次选择都想选个大的，但是最大的不能选（因为 min），所以每次选第二大的。
     * 思路: 将数组排序 1 2 3 4 ==> (1,2) (3,4) 最大值为 1 + 3 = 4
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i+=2) {
            sum+=nums[i];
        }

        return sum;
    }
}
