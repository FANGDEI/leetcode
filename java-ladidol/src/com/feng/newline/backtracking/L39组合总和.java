package com.feng.newline.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L39组合总和
 * @author: Ladidol
 * @description: 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的
 * 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * <p>
 * 示例1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * @date: 2022/8/11 13:23
 * @version: 1.0
 */
public class L39组合总和 {
    class Solution1 {
        int[] candidates;
        int target;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            this.target = target;
            backtracking(0, 0);
            return res;
        }

        void backtracking(int sum, int startIndex) {//startIndex还存在的作用：避免出现233,232,322这样的重复解。
            if (sum > target) return;//由于暴力搜索，不剪枝的话可能会栈溢出：java.lang.StackOverflowError
            if (sum == target) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                cur.add(candidates[i]);
                sum += candidates[i];
                backtracking(sum, i);//可重复读当前数字
                sum -= candidates[i];
                cur.removeLast();
            }
        }
    }

    //for循环剪枝代码如下：
    //for (int i = startIndex; i < candidates.size() && sum + candidates[i] <= target; i++)

    //对总集合排序之后，如果下一层的sum（就是本层的 sum + candidates[i]）已经大于target，就可以结束本轮for循环的遍历。

    class Solution {
        int[] candidates;
        int target;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            this.target = target;
            Arrays.sort(candidates);//需要排序了。
            backtracking(0, 0);
            return res;
        }

        void backtracking(int sum, int startIndex) {//startIndex还存在的作用：避免出现233,232,322这样的重复解。
            if (sum > target) return;//由于暴力搜索，不剪枝的话可能会栈溢出：java.lang.StackOverflowError
            if (sum == target) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
                cur.add(candidates[i]);
                sum += candidates[i];
                backtracking(sum, i);//可重复读当前数字
                sum -= candidates[i];
                cur.removeLast();
            }
        }
    }

}
