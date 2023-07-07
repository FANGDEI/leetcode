package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Devildyw
 * @date 2023/07/07 11:41
 **/
@SuppressWarnings("all")
public class OII036后缀表达式 {

    public static void main(String[] args) {
        System.out.println(new OII036后缀表达式().evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))||token.charAt(0)=='-'&&token.length()>1){
                stack.push(Integer.valueOf(token));
            }else{
                int temp = 0;
                Integer a1 = stack.pop();
                Integer a2 = stack.pop();
                if (token.equals("+")){
                    temp = a1+a2;
                } else if (token.equals("-")){
                    temp = a2-a1;
                } else if (token.equals("/")) {
                    temp = a2 / a1;
                } else{
                    temp = a2 * a1;
                }

                stack.push(temp);
            }
        }
        return stack.pop();
    }
}
