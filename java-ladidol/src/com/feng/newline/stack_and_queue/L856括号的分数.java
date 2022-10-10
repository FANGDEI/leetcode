package com.feng.newline.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: ladidol
 * @date: 2022/10/9 12:33
 * @description: 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 * <p>
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 * <p>
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 */
public class L856括号的分数 {


    // 栈
    class Solution1 {
        /**
         * 参数：[s]
         * 返回值：int
         * 作者： lad idol
         * 描述：
         * <p>
         * 题目要求：
         * 1. 如果是嵌套括号，得分要乘二
         * 2. 如果是并列，得分相加（这里很神奇的就是和零相加的话，职责和零差不多。）
         * 右括号=0，左括号开始运算，注意X(累加相邻项
         */
        public int scoreOfParentheses(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            char[] chars = s.toCharArray();
            stack.push(0);//初始化一下stack
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    stack.push(0);
                } else {
                    int cur = stack.poll();
                    cur = cur == 0 ? 1 : cur * 2;
                    stack.push(stack.poll() + cur);//有点点小迷惑。
                }
            }
            return stack.peek();
        }
    }

    // 脑筋急转弯
    class Solution {
        /**
         * 参数：[s]
         * 返回值：int
         * 作者： ladidol
         * 描述：只有（）会产生得分，得分多少根据depth来计算。
         */
        public int scoreOfParentheses(String s) {
            int depth = 0;
            int ans = 0;

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') depth++;
                else {//有产生得分的部分了。
                    depth--;
                    if (chars[i-1]=='(') ans += 1 << depth;//当且仅当（）有得分。
                }
            }
            return ans;
        }
    }

}