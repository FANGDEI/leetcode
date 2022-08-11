package com.feng.newline.backtracking;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L40组合总和II
 * @author: Ladidol
 * @description: 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 * 示例1:
 * <p>
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * @date: 2022/8/11 13:52
 * @version: 1.0
 */
public class L40组合总和II {
    //相比39题：这题cur中的元素可以是重复的，是不能重复利用candidates中的元素；res中的解不能重复！
    //本题的难点在于区别2中：集合（数组candidates）有重复元素，但还不能有重复的组合。
    //还有个奇葩极端的测试用例：
    //[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
    //30
    class Solution {
        //所以：同一层上的“使用过”，去重；
        // 同一条路径上的都是一个组合里的元素，不用去重。
        int[] candidates;
        int target;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            this.candidates = candidates;
            this.target = target;
            Arrays.sort(candidates);//需要排序了。
            backtracking(0, 0);
            return res;
        }

        void backtracking(int sum, int startIndex) {//startIndex还存在的作用：避免出现233,232,322这样的重复解。
            if (sum > target) return;//由于暴力搜索，不剪枝的话可能会栈溢出：java.lang.StackOverflowError
            if (sum == target) {
                if (res.contains(cur)) return;
                res.add(new ArrayList<>(cur));
                return;
            }
//            Set<Integer> set = new HashSet<>();//用set也行，只是效率要低一点。
            int pre = 0;//这里我们用一个指针指向前一个就行了。
            for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
//                if (!set.add(candidates[i])) continue;//同层有重复元素，就跳过它就行。
                if (pre == candidates[i]) continue;//同层有重复元素，就跳过它就行。
                pre = candidates[i];
                cur.add(candidates[i]);
                sum += candidates[i];
                backtracking(sum, i + 1);//不能重复使用。
                sum -= candidates[i];
                cur.removeLast();
            }
        }
    }
}
