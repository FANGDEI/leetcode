package com.feng.leetcode.offer._01字符串;

public class 剑指Offer20表示数值的字符串 {


    //数学归纳
    class Solution {
        /**
         * https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/discussion/comments/460400
         * https://blog.csdn.net/z3881006/article/details/77887795
         * 编码没什么难度，难点在于归纳各种正确的情况
         * ‘.’出现正确情况：只出现一次，且在e的前面 dotFlag标记小数点状态
         * ‘e’出现正确情况：只出现一次，且出现前有数字 eFlag标记Ee出现状态
         * ‘+’‘-’出现正确情况：只能在开头和e后一位
         *
         * 其中最为精彩的是：numFlag的标志位，他可以标志是否是数字结尾，同时标志前面出现过的情况。
         *
         *
         * @param s
         * @return
         */
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) return false;
            //去掉首位空格
            s = s.trim();
            boolean numFlag = false;
            boolean dotFlag = false;
            boolean eFlag = false;
            for (int i = 0; i < s.length(); i++) {
                //判定为数字，则标记numFlag
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    numFlag = true;
                    //判定为.  需要没出现过.并且没出现过e
                } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                    dotFlag = true;
                    //判定为e，需要没出现过e，并且出过数字了
                } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                    eFlag = true;
                    numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                    //判定为+-符号，只能出现在第一位或者紧接e后面
                } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                    //其他情况，都是非法的
                } else {
                    return false;
                }
            }
            return numFlag;
        }
    }


}
