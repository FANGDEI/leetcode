package com.jirafa.leetcode.algorithm.greedy;

/**
 * https://leetcode.cn/problems/jump-game/
 */
public class L55 {
    public boolean canJump(int[] nums) {
//        return dfs(nums,0);
        if (nums.length == 1)
            return true;
        int coverage=0;
//        int location=0;
//        while (location<nums.length&&location<=coverage) {
//            for (int i = 1; i <= nums[location]; i++) {
//                coverage = Math.max(coverage, i + location);
//                if (coverage >= nums.length - 1)
//                    return true;
//            }
//            location++;
//        }
        for (int i = 0; i <= coverage; i++) {
            coverage=Math.max(coverage,i+nums[i]);
            if (coverage >= nums.length - 1)
                    return true;
        }

        return false;
    }

    private boolean dfs(int[] nums,int index){
        if(index==nums.length-1)
            return true;
        int cur = nums[index];
        for (int i = 1; i <= cur; i++) {
            if(dfs(nums, index+i))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        boolean b = new L55().canJump(new int[]{2,3,1,1,4});
        System.out.println(b);
    }
}