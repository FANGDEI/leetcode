package com.dyw.leetcode.simple;

/**
 * @author Devil
 * @date 2022-05-22-15:21
 * <p>
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 */
@SuppressWarnings("all")
public class L643子数组最大平均数I {
    public static void main(String[] args) {
        new L643子数组最大平均数I().findMaxAverage(new int[]{},2);
    }


    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        //先固定一个窗口大小为k
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int sumMax = sum;
        //滑动窗口 每次走一步就删除最开始的一个值 加入下一个值达到滑动的效果
        for (int i = k; i < n; i++) {
            sum = sum - nums[i-k] + nums[i];
            sumMax = Math.max(sumMax, sum);
        }
        return 1.0 * sumMax / k;
    }

    /**
     * 滑动窗口常规写法
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage01(int[] nums, int k) {
        double re = 0;
        double avr = 0;
        int left = 0;
        int right = 0;

        double max = -9999;

        while(right < nums.length){
            avr+=nums[left];
            while (right - left + 1 > k){
                avr -=nums[left];
                left++;
            }
            if (right-left+1 == k){
                if (avr/k>max){
                    max = avr/k;
                }
            }
            right++;
        }
        return max;
    }
}
