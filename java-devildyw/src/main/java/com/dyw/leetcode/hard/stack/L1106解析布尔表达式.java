package com.dyw.leetcode.hard.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Devil
 * @since 2022-11-05-0:16
 */
@SuppressWarnings("all")
public class L1106解析布尔表达式 {

    public static void main(String[] args) {
        System.out.println(new L1106解析布尔表达式().parseBoolExpr("&(t,f)"));
    }

    /**
     * 模拟
     * @param expression
     * @return
     */
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = expression.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            //括号内的逗号不做计算 只计入有效符号 () | ! & t f
            if (chars[i]==','){
                continue;
            } else if (chars[i]!=')') { //如果不为) 则将字符加入栈中
                stack.push(chars[i]);
            } else{ //如果为)
                //代表这里作为一个括号的收尾 这里要计算该括号内的值了
                int t=0,f=0;
                while (stack.peek()!='('){
                    char pop = stack.pop();
                    if (pop=='t'){
                        t++;
                    }else{
                        f++;
                    }
                }
                stack.pop();
                Character op = stack.pop();
                switch (op){
                    case '!': //! 一般只和一个字母一起出现 所以遇到f就为t 如果是t就是f
                        stack.push(f==1?'t':'f');
                        break;
                    case '&': //& 与 遇到f 则为f
                        stack.push(f==0?'t':'f');
                        break;
                    case '|': //或 遇到 t 则 t
                        stack.push(t>0?'t':'f');
                        break;
                    default:
                        break;
                }
            }

        }
        return stack.peek()=='t';

    }
}
