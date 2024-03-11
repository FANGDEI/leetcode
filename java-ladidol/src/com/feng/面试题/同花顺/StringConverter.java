package com.feng.面试题.同花顺;

public class StringConverter {
    public static String convertToUpperCase(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        return input.toUpperCase();
    }

    public static void main(String[] args) {
        String input = "welcome nihao";
        String result = convertToUpperCase(input);
        System.out.println(result);  // 输出 "WELCOME"
    }
}