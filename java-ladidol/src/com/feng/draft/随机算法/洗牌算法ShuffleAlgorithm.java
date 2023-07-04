package com.feng.draft.随机算法;

import java.util.Random;

public class 洗牌算法ShuffleAlgorithm {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffle(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = nums.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


}