package com.feng.review.搜素or回溯;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/9 19:56
 * @description: {}
 */
public class O38字符串的排列 {


    class Solution {
        /**
         * dfs+回溯，去重需要用染色，同时需要，耳目一新，豁然开朗
         *
         * @param s
         * @return
         */
        public String[] permutation(String s) {

            char[] chars = s.toCharArray();
            isVisited = new boolean[s.length()];
            Arrays.sort(chars);//方便去重
            dfs(chars, 0, "");
//            System.out.println("res = " + res);
            return res.toArray(new String[0]);
        }

        boolean[] isVisited;
        List<String> res = new ArrayList<>();

        void dfs(char[] chars, int deep, String curS) {
            if (deep == chars.length) {
                res.add(curS);
            }
            for (int i = 0; i < chars.length; i++) {
                if (isVisited[i]) continue;//去重自己
                if (i > 0 && chars[i - 1] == chars[i] && !isVisited[i - 1]) continue;//去重别人，同时保证第一次出现的都能通过
                isVisited[i] = true;
                dfs(chars, deep + 1, curS + chars[i]);
                isVisited[i] = false;
            }
        }
    }


}
