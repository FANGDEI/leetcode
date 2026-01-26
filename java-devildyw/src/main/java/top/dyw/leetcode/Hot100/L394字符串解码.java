package top.dyw.leetcode.Hot100;

import java.util.*;
public class L394字符串解码 {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();
                StringBuilder tempCount = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() <= '9' && stack.peek() >= '0') {
                    tempCount.append(stack.pop() - '0');
                }
                int count = Integer.parseInt(tempCount.reverse().toString());
                String reverse = sb.reverse().toString();
                StringBuilder tempStr = new StringBuilder();
                while (count-- > 0) {
                    tempStr.append(reverse);
                }

                for (char ch : tempStr.toString().toCharArray()) {
                    stack.push(ch);
                }
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
