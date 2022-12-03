package com.dyw.leetcode.TOP面试题;

/**
 * @author Devil
 * @since 2022-11-06-13:57
 */
@SuppressWarnings("all")
public class L8字符串转换整数atoi {

    public static void main(String[] args) {
        System.out.println(new L8字符串转换整数atoi().myAtoi("4193 with words"));
    }

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();

        //去除前导空格 可以使用 str.trim()
        int index = 0;
        while (index<str.length()&&chars[index]==' '){
            index++;
        }

        //如果全是空格情况
        if (index==chars.length){
            return 0;
        }

        //记录符号
        int sign = 1; //默认正号
        if (chars[index]=='+'){
            index++;
        }else if (chars[index]=='-'){
            index++;
            sign = -1;
        }
        int result = 0;
        while (index<chars.length){
            char ch = chars[index++];

            if (ch<'0'||ch>'9') break;

            int num = ch - '0';
            if (result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&num>7)){
                return Integer.MAX_VALUE;
            }
            if (result<Integer.MIN_VALUE/10||(result==Integer.MIN_VALUE/10&&num>8)){
                return Integer.MIN_VALUE;
            }
            result = result*10+sign*num;
        }
        return result;
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
