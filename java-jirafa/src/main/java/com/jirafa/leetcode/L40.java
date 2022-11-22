package com.jirafa.leetcode;

import java.lang.reflect.Constructor;
import java.util.*;

public class L40 {
    Set<List<Integer>> result=new HashSet<>();
    LinkedList<Integer> path=new LinkedList<>();
    int sum;
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        sum=0;
        used=new boolean[candidates.length];
        Arrays.fill(used,false);
        Arrays.sort(candidates);
        backTracking(candidates, target,0);
        return new LinkedList<>(result);
    }

    public void backTracking(int[] nums,int target,int index){
        if(sum>target)
            return;
        if(sum==target){
            result.add(new ArrayList<>(this.path));
            return;
        }

        for(int i=index;i<nums.length;i++){
            if(sum+nums[i]<=target){
                if(i>0&&nums[i-1]==nums[i]&&!used[i-1]){
                    continue;
                }
                path.add(nums[i]);
                sum+=nums[i];
                used[i]=true;
                backTracking(nums,target,i+1);
                used[i]=false;
                path.removeLast();
                sum-=nums[i];
//                System.out.println("popsum: "+sum);
//                System.out.println(path.toString());
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        L40 l40 = new L40();

        l40.combinationSum2(new int[]{
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
        },30);


        System.out.println(l40.result.toString());
    }
}
