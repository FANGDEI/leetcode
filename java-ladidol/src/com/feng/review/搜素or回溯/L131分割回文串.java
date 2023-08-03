package com.feng.review.搜素or回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/2 22:45
 * @description: {}
 */
public class L131分割回文串 {
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
            if (startIndex == s.length()) {
                res.add(new LinkedList<>(cur));
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (!isPalindrome(startIndex, i)) {
                    //说明当前不能切割，我们可以往后面切割看看
                    continue;
                }
                cur.add(s.substring(startIndex, i + 1));//这里注意是i+1
                backtracking(i + 1);
                cur.removeLast();
            }


        }

        //判断回文
        boolean isPalindrome(int start, int end) {
            for (int i = start, j = end; i < j; i++, j--) {//i<j，注意别粗心！
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }
}
