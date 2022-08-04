package com.dyw.leetcode.simple.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2022-07-19-11:02
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
@SuppressWarnings("all")
public class L20有效的括号 {
    public static void main(String[] args) {
        System.out.println(new L20有效的括号().isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                if (c == ')') {
                    Character peek = stack.peek();
                    if (peek == '(') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else if (c == '}') {
                    Character peek = stack.peek();
                    if (peek == '{' && !stack.isEmpty()) {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else if (c == ']') {
                    Character peek = stack.peek();
                    if (peek == '[') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            } else {
                return false;
            }
        }
        if (flag && stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
