package com.feng.review.搜素or回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/17 14:09
 * @description: {}
 */
public class L216组合总和III {
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
