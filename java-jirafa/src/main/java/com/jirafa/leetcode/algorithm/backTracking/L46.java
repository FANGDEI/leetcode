package com.jirafa.leetcode.algorithm.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L46 {
    List<List<Integer>> result;
    List<Integer> path;
    Boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        result=new ArrayList<>();
        path=new LinkedList<>();
        used=new Boolean[nums.length];
        Arrays.fill(used, false);
        backTracking(nums,0);
        return result;
    }

    public void backTracking(int[] nums,int start){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
//            if(!used[i])
            if(path.contains(nums[i]))
            {
                path.add(nums[i]);
                used[i]=true;
                backTracking(nums,0);
                path.remove(path.size()-1);
                used[i]=false;
            }
        }


    }
}
