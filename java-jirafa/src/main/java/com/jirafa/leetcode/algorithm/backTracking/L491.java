package com.jirafa.leetcode.algorithm.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L491 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0);
        return result;
    }

    public void backTracking(int[] nums,int start) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

//        HashMap<Integer, Boolean> map = new HashMap<>();
        int[] used=new int[201];
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)|| used[nums[i]+100]>0)
                continue;
//            if (map.getOrDefault(nums[i], false)) {
//                continue;
//            }
            path.add(nums[i]);
            used[nums[i]+100]++;
//            map.put(nums[i], true);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        L491 l491 = new L491();
        System.out.println(l491.findSubsequences(new int[]{4,7,6,7}));
    }
}
