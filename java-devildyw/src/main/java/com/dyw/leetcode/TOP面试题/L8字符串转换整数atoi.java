package com.dyw.leetcode.TOP面试题;

/**
 * @author Devil
 * @since 2022-11-06-13:57
 */
@SuppressWarnings("all")
public class L8字符串转换整数atoi {

    public static void main(String[] args) {
        System.out.println(new L8字符串转换整数atoi().myAtoi("-91283472332"));
    }

    public int myAtoi(String str) {
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }

    public int myAtoi01(String str) {
        char[] chars = str.toCharArray();
        //去除前导空格
        int index = 0;
        while (index < str.length() && chars[index] == ' ') {
            index++;
        }

        //排除极端情况全是空格的情况
        if (index == chars.length) {
            return 0;
        }

        //判断符号
        int sign = 1;
        char firstChar = chars[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-'){
            index++;
            sign = -1;
        }

        int res = 0;
        while (index++ < chars.length) {
            char currChar = chars[index];

            //判断是否是数字字符
            if (currChar > '9' || currChar < '0') {
                break;
            }

            //判断特殊情况 是否数字长度超过上限
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && currChar - '0' > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && currChar - '0' > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res*10+sign*(currChar-'0');
        }
        return res;
    }
}
