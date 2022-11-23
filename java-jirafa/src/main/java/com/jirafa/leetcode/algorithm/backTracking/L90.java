package com.jirafa.leetcode.algorithm.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L90 {
    List<List<Integer>> result=new LinkedList<>();
    List<Integer> path=new LinkedList<>();
    Boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used=new Boolean[nums.length];
        Arrays.sort(nums);
        Arrays.fill(used, false);
        backTracking(nums,0);
        return result;
    }

    public void backTracking(int[] nums,int start){
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if(i!=0&&nums[i]==nums[i-1]&&!used[i-1]){
                path.add(nums[i]);
                used[i]=true;
                backTracking(nums,start);
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}
