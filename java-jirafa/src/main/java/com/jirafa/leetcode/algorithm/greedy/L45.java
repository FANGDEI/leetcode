package com.jirafa.leetcode.algorithm.greedy;

/**
 * https://leetcode.cn/problems/jump-game-ii/
 */

public class L45 {
    public int jump(int[] nums) {
        int ans = 0;
        if (nums.length == 1)
            return ans;
        int coverage=0,cur=0;
        for (int i = 0; i <= cur; i++) {
            coverage=Math.max(coverage,i+nums[i]);
            if(coverage>=nums.length-1) {
                ans++;
                break;
            }
            if(i==cur){
                cur=coverage;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int jump = new L45().jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3});
        System.out.println(jump);
    }

}
