package top.dyw.nowcoder.top100;

import java.util.Stack;

/**
 * @author Devil
 * @since 2023-01-30-11:56
 */
@SuppressWarnings("all")
public class BM44有效括号序列 {

    public static void main(String[] args) {
        System.out.println(new BM44有效括号序列().isValid("[]"));
    }

    public boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    if (c == ')' && stack.peek() == '(' || c == '}' && stack.peek() == '{' || c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
        }

        if (flag && !stack.isEmpty()) {
            flag = false;
        }

        return flag;
    }
}
