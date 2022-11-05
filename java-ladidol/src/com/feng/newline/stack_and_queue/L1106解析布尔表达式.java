package com.feng.newline.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: ladidol
 * @date: 2022/11/5 11:36
 * @description: 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * 有效的表达式需遵循以下约定：
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 * 示例 1：
 * <p>
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 * 提示：
 * <p>
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 */
public class L1106解析布尔表达式 {
    //双栈解决表达式问题，感觉可以专门来做一下这些题。
    class Solution {

        /**
         * 参数：[expression]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：一个装数字的栈，一个来装运行符号的栈。
         * 从后面往前面看，从最里面的括号开始一个一个的转换。
         */
        public boolean parseBoolExpr(String expression) {
            Deque<Integer> numsStack = new ArrayDeque<>();
            Deque<Character> opsStack = new ArrayDeque<>();
            int n = expression.length();
            int ans = 1;
            for (int i = 0; i < n; i++) {
                char cur = expression.charAt(i);
                if (cur == ',') continue;
                else if (cur == 'f' || cur == 't') numsStack.push(cur == 't' ? 1 : -1);
                else if (cur == '&' || cur == '|' || cur == '!') opsStack.push(cur);
                else if (cur == '(') numsStack.push(0);
                else if (cur == ')') {
                    int tmp = 100;
                    while (numsStack.peek() != 0 && !opsStack.isEmpty()) {
                        int peek = numsStack.pop();
                        tmp = tmp == 100 ? peek : calc(tmp, peek, opsStack.peek());
                    }
                    ans = tmp;
                    if (opsStack.peek() == '!') ans *= -1;
                    numsStack.pop();
                    opsStack.pop();
                    numsStack.push(ans);
                }
            }
            return ans == 1;
        }

        int calc(int sum, int peek, char ops) {
            boolean a = sum == 1, b = peek == 1;
            boolean ans = (ops == '|') ? (a | b) : (a & b);
            return ans ? 1 : -1;
        }


    }
}