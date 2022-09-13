package com.feng.newline.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L1190反转每对括号间的子串
 * @author: Ladidol
 * @description: 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 解释：先反转子字符串 "love" ，然后反转整个字符串。
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 * @date: 2022/9/12 22:02
 * @version: 1.0
 */
public class L1190反转每对括号间的子串 {

    // 栈
    class Solution {
        // 基本分析
        //根据题意，我们可以设计如下处理流程：
        //
        //1. 从前往后遍历字符串，将不是 ) 的字符串从「尾部」放入队列中
        //2. 当遇到 ) 时，从队列「尾部」取出字符串，直到遇到 ( 为止，并对取出字符串进行翻转
        //3. 将翻转完成后字符串重新从「尾部」放入队列
        //4. 循环上述过程，直到原字符串全部出来完成
        //5. 从队列「头部」开始取字符，得到最终的答案
        public String reverseParentheses(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            char[] chars = s.toCharArray();


            for (char c : chars) {
                if (c == ')') {
                    StringBuilder path = new StringBuilder();
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        path.append(stack.pop());
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();// 弹出'('
                    }
                    for (int i = 0; i < path.length(); i++) {//取出来的再次放进去（已经完成翻转了）
                        stack.push(path.charAt(i));// 重新放回stack中。
                    }
                } else {
                    stack.push(c);
                }
            }

            StringBuilder res = new StringBuilder();
            while (!stack.isEmpty()) {
                res.append(stack.pop());
            }
            return res.reverse().toString();
        }
    }


    // 一种是直接通过stack中共存入下标。

}
