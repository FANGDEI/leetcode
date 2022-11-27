package com.jirafa.leetcode.algorithm.greedy;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/candy/
 */
public class L135 {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);
        for (int i = 1; i < ratings.length ; i++) {
            if(ratings[i] > ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }
        }
        for (int i = ratings.length-2; i >= 0; i--) {
            if(ratings[i]>ratings[i+1]){
                candy[i]=Math.max(candy[i+1]+1,candy[i]);
            }
        }

        return Arrays.stream(candy).sum();
    }

    public static void main(String[] args) {
        System.out.println(new L135().candy(new int[]{1,3,4,5,2}));
    }
}
