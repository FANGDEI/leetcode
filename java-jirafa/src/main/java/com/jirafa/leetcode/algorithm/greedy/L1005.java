package com.jirafa.leetcode.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
 */
public class L1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Integer[] integers=Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(integers, Comparator.comparingInt(Math::abs));
        for (int i = integers.length-1; i >0 ; i--) {
            if(integers[i]<=0&&k>0){
                integers[i]=-1*integers[i];
                k--;
            }
        }

        if(k%2==1) integers[0]=-1*integers[0];
        int sum=0;
        for(int i:integers){
            sum+=i;
        }

        return sum;
    }

    public static void main(String[] args) {
        int i = new L1005().largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2);
        System.out.println(i);
    }

}
