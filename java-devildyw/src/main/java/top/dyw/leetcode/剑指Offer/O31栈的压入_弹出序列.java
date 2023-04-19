package top.dyw.leetcode.剑指Offer;

import java.util.Stack;

/**
 * @author Devildyw
 * @date 2023/04/19 16:38
 **/
@SuppressWarnings("all")
public class O31栈的压入_弹出序列 {

    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed==null||pushed.length==0){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        int pointer = 0;
        for (int i = 0; i < n; i++) {
            //入栈
            stack.push(pushed[i]);
            //判断当前栈顶是否是此时出栈队列的指针指向的元素 是则出栈  模拟入栈出栈的情况
            while (!stack.isEmpty()&&stack.peek()==popped[pointer]){
                stack.pop();
                pointer++;
            }
        }

        //如果最后栈空则代表恰好能够满足出栈队列
        return stack.isEmpty();
    }
}
