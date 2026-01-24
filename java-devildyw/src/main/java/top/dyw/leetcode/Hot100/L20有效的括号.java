package top.dyw.leetcode.Hot100;

import java.util.*;

public class L20有效的括号 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for(char c : s.toCharArray()) {
            if (c=='(') {
                stack.push(')');
            } else if (c=='{') {
                stack.push('}');
            } else if (c=='[') {
                stack.push(']');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.peek()==c) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
        }

        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
