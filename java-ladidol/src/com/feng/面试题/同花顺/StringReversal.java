package com.feng.面试题.同花顺;

public class StringReversal {
    public static String reverseString(String str) {
        // Base case: 如果字符串为空或只有一个字符，直接返回
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        // 递归步骤：将字符串分成第一个字符和剩余部分，递归反转剩余部分，并将结果与第一个字符拼接
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "hello, world!";
        String reversedStr = reverseString(str);
        System.out.println(reversedStr);  // 输出 "!dlrow ,olleh"
    }
}