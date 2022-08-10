package com.feng.newline.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L216组合总和III
 * @author: Ladidol
 * @description: 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次 
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * @date: 2022/8/10 23:02
 * @version: 1.0
 */
public class L216组合总和III {

    public static void main(String[] args) {
//        System.out.println(new Solution().combinationSum3(3, 7));
    }

    class Solution {
        int n;
        int k;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        int sum = 0;

        public List<List<Integer>> combinationSum3(int k, int n) {
            this.k = k;
            this.n = n;
            backtracking(1);
            return res;
        }

        void backtracking(int curValue) {
            if (sum > n) {//这里是直接剪枝，其中一个判断条件满足，就直接剪枝。
                return;
            }
            //停止条件
            if (cur.size() == k) {
                if (sum == n) {//满足条件退出。
                    res.add(new ArrayList<>(cur));
                }//如果不满足条件，但到底，也可以退出。
                return;
            }
            //回溯搜索的遍历过程
            for (int i = curValue; i <= 9; i++) {//依旧可以剪枝优化。
                cur.add(i);//这里不要写错了，这里要加的是i
                sum += i;
                backtracking(i + 1);
                cur.removeLast();//直接使用LinkedList就行了，List不是万能的。//回溯
                sum -= i;
            }
        }
    }
}


