package top.dyw.leetcode.simple.stack;

import java.util.Stack;

/**
 * @author Devildyw
 * @date 2023/12/23 19:32
 **/
@SuppressWarnings("all")
public class L682棒球比赛 {

    public static void main(String[] args) {
        System.out.println(new L682棒球比赛().calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }

    /**
     * 栈模拟
     * @param operations
     * @return
     */
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("C")){
                stack.pop();
            }else if (operations[i].equals("D")){
                Integer peek = stack.peek();
                stack.push(2*peek);
            }else if (operations[i].equals("+")){
                Integer top = stack.pop();
                Integer peek = stack.peek();
                Integer result = top + peek;

                stack.push(top);
                stack.push(result);
            }else{
                stack.push(Integer.valueOf(operations[i]));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;
    }
}
