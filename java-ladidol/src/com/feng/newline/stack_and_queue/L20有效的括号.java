package com.feng.newline.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.stack_and_queue
 * @className: L20有效的括号
 * @author: Ladidol
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * @date: 2022/7/27 21:53
 * @version: 1.0
 */
public class L20有效的括号 {

    //分析示例4会发现一个棘手的问题就是要考虑括号里外包括顺序吗
    //然而并不是, 这里是需要在一类括号范围内其他括号要闭合.
    //解决方案就是如下.
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
//            Deque<Character> stack = new LinkedList<>();
            for (char ch : s.toCharArray()) {
                //碰到左括号，就把相应的右括号入栈
                if (ch == '(') {
                    stack.push(')');
                } else if (ch == '{') {
                    stack.push('}');
                } else if (ch == '[') {
                    stack.push(']');
                } else if (stack.isEmpty() || stack.peek() != ch) {
                    //没出现左括号或者栈顶不是对应类的括号
                    return false;
                } else{
                    //这里说明和栈顶括号匹配
                    stack.pop();
                }
            }
            return stack.isEmpty();//避免出现剩余左括号的情况
        }
    }
}
