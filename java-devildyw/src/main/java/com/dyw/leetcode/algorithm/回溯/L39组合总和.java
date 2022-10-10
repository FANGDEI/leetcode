package com.dyw.leetcode.algorithm.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 * @author Devil
 * @since 2022-10-10-13:02
 */
@SuppressWarnings("all")
public class L39组合总和 {

    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //对数组进行排序 做剪枝优化
        Arrays.sort(candidates);
        combinationSumHelp(candidates,target,0,0);
        return result;
    }

    private void combinationSumHelp(int[] candidates, int target,int sum,int startIndex) {

        if (sum==target){
            result.add(new ArrayList<>(path));
        }

//        for (int i = startIndex; i<candidates.length; i++){
//            sum+=candidates[i];
//            path.add(candidates[i]);
//            combinationSumHelp(candidates,target,sum,i);
//            sum-=candidates[i];
//            path.removeLast();
//        }

        //剪枝优化
        for (int i = startIndex; i<candidates.length; i++){
            if ((sum+candidates[i])>target) break;
            path.add(candidates[i]);
            //这里的startIndex没有加1 就代表可以是可以重复选取
            combinationSumHelp(candidates,target,sum+candidates[i],i);
            path.removeLast();
        }

    }
}
