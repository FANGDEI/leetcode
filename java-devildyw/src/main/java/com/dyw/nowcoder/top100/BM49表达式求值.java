package com.dyw.nowcoder.top100;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Devil
 * @since 2023-02-01-19:09
 */
@SuppressWarnings("all")
public class BM49表达式求值 {

    public static void main(String[] args) {

    }

    public int solve (String s) {
        // write code here
        ArrayList<Integer> res = solveHelper(s,0);
        return res.get(0);
    }

    private ArrayList<Integer> solveHelper(String s, int index) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        int i;

        for (i = index; i < s.length(); i++) {
            //数字转换为 int 数字
            //判断是否为数字
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                num = num*10+s.charAt(i)-'0';
                if (i!=s.length()-1){
                    continue;
                }
            }

            //碰到 '('时，把真个括号内的当成一个数字处理
            if (s.charAt(i)=='('){
                //递归处理括号
                ArrayList<Integer> res = solveHelper(s, i + 1);
                num = res.get(0);
                i = res.get(1);
                if (i!=s.length()-1){
                    continue;
                }
            }

            switch (op){
                //加减号先入栈
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    //相反数
                    stack.push(-num);
                    break;
                //优先计算乘号
                case '*':
                    int temp = stack.pop();
                    stack.push(temp*num);
                    break;
            }

            num = 0;
            //右括号结束递归
            if (s.charAt(i)==')'){
                break;
            }else{
                op = s.charAt(i);
            }

        }

        int sum = 0;
        //栈中元素相加
        while (!stack.isEmpty()){
            sum+=stack.pop();
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(sum);
        temp.add(i);
        return temp;
    }
}
