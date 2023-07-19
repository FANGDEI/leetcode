package com.feng.leetcode.offer._01字符串;

public class 剑指Offer67把字符串转换成整数 {





    class Solution {
        /**
         * https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/solutions/1360707/-by-leetcode_xsong-899k/
         *
         * 关键步骤：
         * ① res = res * 10 + (chars[i] - '0');
         * ② res 是否大于 MAX_VALUE / 10,并且 int最大值为 2147483647 ，所以我们还需要再判断一次，即：chars[i] > 7
         *
         *
         * @param str
         * @return
         */
        public int strToInt(String str) {
            //去前后空格并且转换为数组
            char[] chars = str.trim().toCharArray();
            if (chars.length == 0) return 0;
            //记录正负号
            int sign = 1;
            //开始遍历的位置刚开始是1 ，因为可能存在第一个字符是符号，后续会判断，不是符号会置为0
            int i = 1;
            //乘10之前判断是否越界
            int number = Integer.MAX_VALUE / 10;
            //记录结果
            int res = 0;
            //如果第一个非空格字符为负号，sign 标记为 -1，如果既不是正也不是负，直接从0开始
            if (chars[0] == '-') {
                sign = -1;
            } else if (chars[0] != '+') {
                i = 0;
            }
            //遍历
            for (int j = i; j < chars.length; j++) {
                //不是数字的话直接退出
                if (chars[j] > '9' || chars[j] < '0') break;
                //判断是否越界问题
                if (res > number || (res == number && chars[j] > '7')) {
                    //根据字符串的第一位的符号来判断是返回最大值还是最小值
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                //字符获取数字需要去掉偏移值 - '0'
                res = res * 10 + (chars[j] - '0');
            }
            //返回结果带正负号
            return res * sign;
        }
    }



}
