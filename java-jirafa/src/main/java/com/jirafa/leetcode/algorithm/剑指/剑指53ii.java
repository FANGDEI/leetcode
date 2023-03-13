package com.jirafa.leetcode.algorithm.剑指;

public class 剑指53ii {
    public int missingNumber(int[] nums) {
        int[] newNums = new int[nums.length + 1];
        for(int i:nums){
            newNums[i]++;
        }

        int missing=0;

        for (int i = 0; i < newNums.length; i++) {
            if(newNums[i]==0) {
                missing = i;
                break;
            }
        }

        return missing;
    }

    public static void main(String[] args) {
        new 剑指53ii().missingNumber(new int[]{1,2,3});
    }
}


