package com.feng.review.搜素or回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/17 20:53
 * @description: {}
 */
public class L17电话号码的字母组合 {


    //回溯
    class Solution {//

        /**
         * 参数：[digits]
         * 返回值：java.util.List<java.lang.String>
         * 作者： ladidol
         * 描述：一眼很简单回溯模拟。
         */
        public List<String> letterCombinations(String digits) {
            String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            if (digits.equals("")) return new ArrayList<>();
            List<String> res = new ArrayList<>();
            dfs(0, "", digits, strings, res);
            return res;
        }

        void dfs(int curIndex, String curPath, String digits, String[] strings, List<String> res) {
            if (curPath.length() == digits.length()) {
                res.add(curPath);
                return;
            }
            char[] chars = strings[digits.charAt(curIndex) - '0'].toCharArray();
            for (char c : chars) {
                dfs(curIndex + 1, curPath + c, digits, strings, res);//自带回溯
            }
        }
    }
}