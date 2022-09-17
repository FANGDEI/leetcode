package com.dyw.leetcode.medium.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 注意两个整数之间的除法只保留整数部分。
 * <p>
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * @author Devil
 * @since 2022-09-17-11:47
 */
@SuppressWarnings("all")
public class L150逆波兰表达式求值 {
    public static void main(String[] args) {
        System.out.println(new L150逆波兰表达式求值().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num1 = deque.pop();
                int num2 = deque.pop();
                if (token.equals("+")){
                    deque.push(num2+num1);
                }
                if (token.equals("-")){
                    deque.push(num2-num1);
                }
                if (token.equals("*")){
                    deque.push(num2*num1);
                }
                if (token.equals("/")){
                    deque.push(num2/num1);
                }
            }else{
                deque.push(Integer.valueOf(token));
            }
        }
        return deque.pop();
    }
}
