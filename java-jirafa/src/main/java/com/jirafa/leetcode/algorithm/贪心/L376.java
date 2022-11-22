package com.jirafa.leetcode.algorithm.贪心;

public class L376 {
    public int wiggleMaxLength(int[] nums) {
        int result=1;
        int preDiff=0;
        int curDiff=0;

        for (int i = 0; i < nums.length - 1; i++) {
            curDiff=nums[i+1]-nums[i];
            if ( preDiff<=0&&curDiff>0 || preDiff>=0&&curDiff<0 ){
                result++;
                preDiff=curDiff;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new L376().wiggleMaxLength(new int[]{1,7,4,9,2,5}));
    }
}
