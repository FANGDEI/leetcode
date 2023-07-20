package com.feng.leetcode.offer._03双指针;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 剑指Offer58_I翻转单词顺序 {


    //api
    class Solution {
        /**
         * 值得注意的是用空格当隔开符，\\s+
         * @param s
         * @return
         */
        public String reverseWords(String s) {
            s = s.trim();
            List<String> wordList = Arrays.asList(s.split("\\s+"));
            Collections.reverse(wordList);
            return String.join(" ", wordList);

        }
    }


}
