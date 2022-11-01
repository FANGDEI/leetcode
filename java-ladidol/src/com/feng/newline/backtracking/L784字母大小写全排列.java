package com.feng.newline.backtracking;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/10/30 17:52
 * @description: 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * 示例 1：
 * <p>
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 示例 2:
 * <p>
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 * 提示:
 * <p>
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 */
public class L784字母大小写全排列 {


    //回溯，未剪枝
    class Solution1 {
        /**
         * 参数：[s]
         * 返回值：java.util.List<java.lang.String>
         * 作者： ladidol
         * 描述：
         */
        public List<String> letterCasePermutation(String s) {
            dfs(s, 0, "");
            return new ArrayList<>(res);
        }

        Set<String> res = new HashSet<>();

        void dfs(String s, int index, String path) {
            if (index == s.length()) {
                res.add(path);
                return;
            }
            char cur = s.charAt(index);
            if (Character.isDigit(cur)) dfs(s, index + 1, path + cur);
            dfs(s, index + 1, path + Character.toLowerCase(cur));
            dfs(s, index + 1, path + Character.toUpperCase(cur));
        }
    }


    //回溯+剪枝+StringBuilder
    class Solution {
        /**
         * 参数：[s]
         * 返回值：java.util.List<java.lang.String>
         * 作者： ladidol
         * 描述：
         */
        public List<String> letterCasePermutation(String s) {
            dfs(s, 0, new StringBuilder());
            return new ArrayList<>(res);
        }

        List<String> res = new ArrayList<>();
        Set<String> visit = new HashSet<>();

        void dfs(String s, int index, StringBuilder path) {

            //记忆性搜索。
            if (visit.contains(path.toString())) return;
            visit.add(path.toString());


            if (index == s.length()) {
                res.add(path.toString());
                return;
            }

            char cur = s.charAt(index);
            if (Character.isDigit(cur)) dfs(s, index + 1, new StringBuilder(path).append(cur));
            dfs(s, index + 1, new StringBuilder(path).append(Character.toLowerCase(cur)));
            dfs(s, index + 1, new StringBuilder(path).append(Character.toUpperCase(cur)));
        }
    }
}