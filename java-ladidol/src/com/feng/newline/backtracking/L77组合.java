package com.feng.newline.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L77组合
 * @author: Ladidol
 * @description: 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * @date: 2022/8/10 22:32
 * @version: 1.0
 */
public class L77组合 {
    class Solution1 {
        int n;
        int k;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            backtracking(1);
            return res;
        }

        void backtracking(int curValue) {
            //停止条件
            if (cur.size() == k) {
                res.add(new ArrayList<>(cur));
                return;
            }
            //回溯搜索的遍历过程
            for (int i = curValue; i <= n; i++) {
                cur.add(i);//处理
                backtracking(i + 1);
                cur.remove(cur.size() - 1);//回溯
            }
        }
    }
    class Solution2 {
        int n;
        int k;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            backtracking(1);
            return res;
        }

        void backtracking(int curValue) {//curValue表示当前层起点值。
            //停止条件
            if (cur.size() == k) {
                res.add(new ArrayList<>(cur));
                return;
            }
            //回溯搜索的遍历过程
            for (int i = curValue; i <= n - (k - cur.size()) + 1; i++){//剪枝优化。
                cur.add(i);//处理
                backtracking(i + 1);
                cur.remove(cur.size() - 1);//回溯
            }
        }
    }
}
