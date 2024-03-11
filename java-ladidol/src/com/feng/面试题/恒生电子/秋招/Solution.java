package com.feng.面试题.恒生电子.秋招;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 查找第 k 个最大的元素
     * @param nums int整型一维数组 待查找的数组
     * @param k int整型 第 k 个最大的元素
     * @return int整型
     */
    public int findKthLargest (int[] nums, int k) {
        // write code here
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = nums.length;
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < n-k; i++) {
            queue.poll();
        }
        return queue.poll();


    }



    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算数组的中心下标
     * @param nums int整型一维数组
     * @return int整型
     */
    public int pivotIndex (int[] nums) {
        // write code here
        int sum = Arrays.stream(nums).sum();
        int totol = 0;
        for (int i = 0; i < nums.length; i++) {
            if (totol+totol+nums[i]== sum){
                return i;
            }
            totol+=nums[i];
        }

        return -1;

    }
}