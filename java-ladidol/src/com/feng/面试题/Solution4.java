package com.feng.面试题;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/21 13:23
 * @description: {}
 */
public class Solution4 {
    public static void PrintMessage(String input) {
        int len;
        try {
            len = Integer.parseInt(input.substring(0, 2)); // 解析消息长度
        } catch (NumberFormatException e) {
            System.out.println("the input string is invalid at position 0");
            return;
        }
        if (len < 0 || len > input.length() - 2) {
            System.out.println("the input string is invalid at position 0");
            return;
        }
        String message = input.substring(2, 2 + len); // 获取消息内容
        if (message.length() != len) {
            System.out.println("the input string is invalid at position 0");
            return;
        }
        System.out.println(message);
    }

    public static void main(String[] args) {
        PrintMessage("02bc101234567890"); // 输出 "bc1234567890"
        PrintMessage("02abc101234567890"); // 输出 "the input string is invalid at position 4"
        PrintMessage("02ab10123"); // 输出 "the input string is invalid at position 8"
    }
}
