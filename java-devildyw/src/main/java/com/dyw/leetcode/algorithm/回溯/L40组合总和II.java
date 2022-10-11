package com.dyw.leetcode.algorithm.回溯;

import java.util.*;

/**
 * @author Devil
 * @since 2022-10-11-11:08
 */
@SuppressWarnings("all")
public class L40组合总和II {

    public static void main(String[] args) {

    }
    //这里使用set去重会超时 直接从数字开始去重 防止在同一层选取时选取到相同的数字
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2Helper(candidates,target,0,0);
        return result;
    }

    private void combinationSum2Helper(int[] candidates, int target, int sum, int startIndex) {
        if (sum==target){
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum>target){
            return;
        }

        for (int i = startIndex; i<candidates.length&&sum+candidates[i]<=target; i++){
            //正确剔除重复解的办法
            //跳过同一树层使用过的元素
            if (i>startIndex&&candidates[i]==candidates[i-1]){
                continue;
            }

            sum+=candidates[i];
            path.add(candidates[i]);
            combinationSum2Helper(candidates,target,sum,i+1);
            sum-=candidates[i];
            path.removeLast();
        }
    }

}
