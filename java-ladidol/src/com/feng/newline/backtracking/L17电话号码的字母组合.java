package com.feng.newline.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L17电话号码的字母组合
 * @author: Ladidol
 * @description: 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * @date: 2022/8/11 12:53
 * @version: 1.0
 */
public class L17电话号码的字母组合 {


    class Solution1 {
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""；通过层数来下标获取九键字母。
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        String digits;

        public List<String> letterCombinations(String digits) {//值得注意的是这里的digits长度是可变的。
            if (digits.equals("")) return res;
            this.digits = digits;
            backtracking(0);//回溯搜索
            return res;
        }

        void backtracking(int numIndex) {
            if (numIndex == digits.length()) {//越界就返回咯。
                res.add(new String(cur));
                return;
            }
            char[] chars = numString[digits.charAt(numIndex) - '0'].toCharArray();//取出当前层的字母数组
            for (int i = 0; i < chars.length; i++) {
                cur.append(chars[i]);//处理
                backtracking(numIndex + 1);//进入下一层
                cur.deleteCharAt(cur.length() - 1);//回溯
            }
        }
    }

    //回溯
    class Solution {//2022年10月19日13:41:37复习

        /**
         * 参数：[digits]
         * 返回值：java.util.List<java.lang.String>
         * 作者： ladidol
         * 描述：一眼很简单回溯模拟。
         */
        public List<String> letterCombinations(String digits) {
            String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            int n = digits.length();
            if (n == 0) return new ArrayList<>();
            dfs(n, 0, strings, "", digits);
            return res;
        }

        List<String> res = new LinkedList<>();

        void dfs(int n, int curIndex, String[] strings, String path, String digits) {
            if (curIndex == n) {
                res.add(path);
                return;
            }
            int index = digits.charAt(curIndex) - '0';
            char[] chars = strings[index].toCharArray();
            for (char c : chars) {
                dfs(n, curIndex + 1, strings, path + c, digits);
            }
        }
    }
}
