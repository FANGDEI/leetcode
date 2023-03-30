package top.dyw.leetcode.medium.stack;

import java.util.*;

/**
 * @author Devildyw
 * @date 2023/03/26 13:11
 **/
@SuppressWarnings("all")
public class L946验证栈序列 {

    public static void main(String[] args) {
        new L946验证栈序列().validateStackSequences(new int[]{2,1,0},new int[]{1,2,0});
    }

    /**
     * 模拟栈
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int index = 0; //记录一个指针，如果此时栈顶的元素为popped数组中指针指向的元素那么就出栈 如果不是则代表出栈顺序有误
        for (int i = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&stack.peek()==popped[index]){
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }
}
