package com.feng.newline.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ladidol
 * @date: 2022/10/19 14:21
 * @description: 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 */
public class L22括号生成 {


    //听说直接回溯
    class Solution {
        /**
         * 参数：[n]
         * 返回值：java.util.List<java.lang.String>
         * 作者： ladidol
         * 描述：
         * <p>
         * 题目性质：
         * 1. 括号数为 n，那么一个合法的括号组合，应该包含 n 个左括号和 n 个右括号，组合总长度为 2n
         * 2. 一对合法的括号，应该是先出现左括号，再出现右括号。那么意味着任意一个右括号的左边，至少有一个左括号
         * <p>
         * 对应解题思路：
         * 1. 左括号加一；右括号减一；
         * 2. 得分不可能超过n，得分不能小于0，最终得分为零。
         * 3. 通过计数表示走到哪一层了
         */
        public List<String> generateParenthesis(int n) {
            dfs(0, 2 * n, n, 0, "");
            return res;
        }

        List<String> res = new ArrayList<>();

        void dfs(int i, int length, int n, int score, String path) {

            if (i == length) {
                if (score == 0) res.add(path);
                return;
            }
            System.out.println("i = " + i + "  score = " + score);
            if (score + 1 <= n) dfs(i + 1, length, n, score + 1, path + '(');//保证score一定是不超过n的。
            if (score - 1 >= 0) dfs(i + 1, length, n, score - 1, path + ')');//保证score一定是大于0的。

        }

    }



}