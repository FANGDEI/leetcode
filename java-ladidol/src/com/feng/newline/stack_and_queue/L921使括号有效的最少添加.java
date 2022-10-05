package com.feng.newline.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: ladidol
 * @date: 2022/10/4 14:35
 * @description: 只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * 它是一个空字符串，或者
 * 它可以被写成AB（A与B连接）, 其中A 和B都是有效字符串，或者
 * 它可以被写作(A)，其中A是有效字符串。
 * 给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。
 * <p>
 * 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
 * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
 * 示例 1：
 * <p>
 * 输入：s = "())"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：s = "((("
 * 输出：3
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 只包含 '(' 和 ')' 字符。
 */
public class L921使括号有效的最少添加 {


    //stack
    class Solution {
        /**
         * 参数：[s]
         * 返回值：int
         * 作者： ladidol
         * 描述：'（' 对应着 '）'
         */
        public int minAddToMakeValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            char[] chars = s.toCharArray();
            int ans = 0;


            for (char c : chars) {
                if (!stack.isEmpty() && c == ')') {
                    stack.pop();
                    continue;
                }
                if (stack.isEmpty() && c == ')') {
                    ans++;
                    continue;
                }
                stack.push(c);
            }
            ans = stack.size() + ans;//stack中还有剩余的'('
            return ans;

        }
    }
}