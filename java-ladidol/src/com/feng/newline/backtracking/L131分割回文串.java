package com.feng.newline.backtracking;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L131分割回文串
 * @author: Ladidol
 * @description: 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 * @date: 2022/8/11 14:20
 * @version: 1.0
 */
public class L131分割回文串 {
    //本题我相信很多同学主要卡在了第一个难点上：就是不知道如何切割，甚至知道要用回溯法，也不知道如何用。也就是没有体会到按照求组合问题的套路就可以解决切割。
    class Solution {

        List<List<String>> res = new ArrayList<>();
        LinkedList<String> cur = new LinkedList<>();
        String s;

        public List<List<String>> partition(String s) {
            this.s = s;
            backtracking(0);
            return res;
        }

        void backtracking(int startIndex) {
            if (startIndex == s.length()) {//找到一组了
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (!isPalindrome(s, startIndex, i)) {//不是回文串
                    continue;
                }
                //是回文串
                cur.add(s.substring(startIndex, i + 1));
                backtracking(i + 1);
                cur.removeLast();//回溯
            }
        }

        //判断回文
        boolean isPalindrome(String s, int start, int end) {
            for (int i = start, j = end; i < j; i++, j--) {//i<j，注意别粗心！
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }
}
