package com.feng.leetcode.offerII._01整数;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/3 15:45
 * @description: {}
 */
public class 剑指OfferII005单词长度的最大乘积 {

    //位运算解决26字母判重操作
    class Solution {
        /**
         * 得到每一个字符串的and值，然后比较两个字符串是不是有重复字符串，只需要判断and值&的值是不是等于零就行了。
         *
         * @param words
         * @return
         */
        public int maxProduct(String[] words) {
            int[] mask = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    mask[i] |= 1 << words[i].charAt(j) - 'a';
                }
            }
            int ans = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if ((mask[i] & mask[j]) == 0) {//如果and等于零，就说明没有相等的1
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }
            return ans;
        }
    }
}
